package com.cnu.swacademy.whereplace.domain.post;

import com.cnu.swacademy.whereplace.domain.comment.Comment;
import com.cnu.swacademy.whereplace.domain.comment.CommentDto;
import com.cnu.swacademy.whereplace.domain.comment.CommentService;
import com.cnu.swacademy.whereplace.domain.hashtag.HashTag;
import com.cnu.swacademy.whereplace.domain.hashtag.HashTagDto;
import com.cnu.swacademy.whereplace.domain.hashtag.HashTagService;
import com.cnu.swacademy.whereplace.domain.post_tag.PostTagService;
import com.cnu.swacademy.whereplace.domain.region.Region;
import com.cnu.swacademy.whereplace.domain.region.RegionService;
import com.cnu.swacademy.whereplace.domain.user.User;
import com.cnu.swacademy.whereplace.domain.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PostService {

    private final UserService userService;
    private final RegionService regionService;
    private final HashTagService hashTagService;
    private final PostTagService postTagService;
    private final ModelMapper modelMapper;
    private final PostRepository postRepository;


    public PostService(UserService userService, RegionService regionService, HashTagService hashTagService, PostTagService postTagService, ModelMapper modelMapper, PostRepository postRepository) {
        this.userService = userService;
        this.regionService = regionService;
        this.hashTagService = hashTagService;
        this.postTagService = postTagService;
        this.modelMapper = modelMapper;
        this.postRepository = postRepository;
    }

    public Post find(int givenPostId){
        Optional<Post> foundPost = postRepository.findById(givenPostId);
        return foundPost.orElse(null);
    }

    @Transactional
    public Post create(PostDto.Request dto) {

        log.warn("DTO INFO : {}",dto.toString());
        Post post = dto.toEntity();

        User user = userService.find(dto.getUserId());
        Region region = regionService.find(dto.getRegionId());

        post.setPostedUser(user);
        post.setRegion(region);
        post.setPostedDate(LocalDateTime.now());

        List<HashTagDto.Request> hashTags = dto.getHashTags();
        createPostTagRelation(post,hashTags);
        // 해시태그 생성 및 중간 테이블 생성

        return postRepository.save(post);
    }

    @Transactional
    public Post update(PostDto.Request dto) {
        Post post = find(dto.getPostId());

        post.setContent(dto.getContent());

        /// PostTagService 의 update 메소드로 빼도 될 것 같음. ///
        postTagService.delete(post);                      ///
        createPostTagRelation(post, dto.getHashTags());   ///
        /////////////////////////////////////////////////////

        post.setRegion(regionService.find(dto.getRegionId()));

        return postRepository.save(post);
    }

    @Transactional
    public void delete(int postId) {
        Post post = this.find(postId);
        try {
            postRepository.delete(post);
        } catch (OptimisticLockingFailureException e) {
            Assert.isTrue(true, " in Post Service : delete");
        }
    }

    public void createPostTagRelation(Post post, List<HashTagDto.Request> hashTags){
        List<HashTag> listOfHashTags = hashTagService.create(hashTags); // 게시글에서 사용하는 해시태그 생성

        if (!listOfHashTags.isEmpty()) {
            listOfHashTags.forEach(hashTag ->
                    postTagService.create(post, hashTag));
        }
    }

    public static PostDto.Response toDto(Post post) {
        return PostDto.Response.builder()
                .postId(post.getPostId())
                .userId(post.getPostedUser().getUserId())
                .content(post.getContent())
                .postedDate(post.getPostedDate())
                .postLike(post.getPostLike())
                .region(RegionService.toDto(post.getRegion())).build();
    }
}
