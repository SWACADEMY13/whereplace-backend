package com.cnu.swacademy.whereplace.domain.post;

import com.cnu.swacademy.whereplace.domain.comment.CommentService;
import com.cnu.swacademy.whereplace.domain.hashtag.HashTagDto;
import com.cnu.swacademy.whereplace.domain.hashtag.HashTagService;
import com.cnu.swacademy.whereplace.domain.image.Image;
import com.cnu.swacademy.whereplace.domain.image.ImageService;
import com.cnu.swacademy.whereplace.domain.post_tag.PostTagService;
import com.cnu.swacademy.whereplace.domain.region.Region;
import com.cnu.swacademy.whereplace.domain.region.RegionService;
import com.cnu.swacademy.whereplace.domain.user.User;
import com.cnu.swacademy.whereplace.domain.user.UserService;
import lombok.extern.slf4j.Slf4j;
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
@Transactional
public class PostService {

//    private final CommentService commentService;
    private final UserService userService;
    private final RegionService regionService;
    private final PostTagService postTagService;
    private final ImageService imageService;
    private final PostRepository postRepository;
    private final HashTagService hashTagService;


    public PostService(UserService userService, RegionService regionService, PostTagService postTagService, ImageService imageService, PostRepository postRepository, HashTagService hashTagService) {
//        this.commentService = commentService;
        this.userService = userService;
        this.regionService = regionService;
        this.postTagService = postTagService;
        this.imageService = imageService;
        this.postRepository = postRepository;
        this.hashTagService = hashTagService;
    }

    public Post find(int givenPostId){
        Optional<Post> foundPost = postRepository.findById(givenPostId);
        return foundPost.orElse(null);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Transactional
    public Post create(PostDto.Request dto) {

        log.warn("DTO INFO : {}",dto.toString());
        Post post = dto.toEntity();

        User user = userService.find(dto.getUsername());
        Region region = regionService.find(dto.getRegionId());

        post.setPostedUser(user);
        post.setRegion(region);
        post.setPostedDate(LocalDateTime.now());

        if (!dto.getHashTags().isEmpty()) {
            List<HashTagDto.Request> hashTags = dto.getHashTags();
            postTagService.create(post,hashTags);
            // 해시태그 생성 및 중간 테이블 생성
        }

        List<Image> images = dto.getImages().stream()
                .map(imageDto -> imageService.create(post, imageDto)).collect(Collectors.toList());

        post.setImages(images);

        return postRepository.save(post);
    }

    @Transactional
    public Post update(PostDto.Request dto) {
        Post post = find(dto.getPostId());

        if (dto.getContent().isPresent()) {
            post.setContent(dto.getContent().get());
        }

        if (!dto.getHashTags().isEmpty()) {
            /// PostTagService 의 update 메소드로 빼도 될 것 같음. ///
            postTagService.delete(post);                      ///
            postTagService.create(post, dto.getHashTags());   ///
            /////////////////////////////////////////////////////
        }


        /// ImageService 의 update 메소드로 빼도 될 것 같음. /////////////////////////////////////////////
        imageService.delete(post);
        List<Image> images = dto.getImages().stream()
                .map(imageDto -> imageService.create(post, imageDto)).collect(Collectors.toList());
        post.setImages(images);
        //////////////////////////////////////////////////////////////////////////////////////////////

        post.setRegion(regionService.find(dto.getRegionId()));
        post.setPostLike(dto.getPostLike());

        return postRepository.save(post);
    }

    @Transactional
    public void delete(int postId) {
        Post post = this.find(postId);
        try {
//            commentService.delete(post);
            imageService.delete(post);
            postTagService.delete(post);
            postRepository.delete(post);
        } catch (OptimisticLockingFailureException e) {
            Assert.isTrue(true, " in Post Service : delete");
        }
    }

//    public void createPostTagRelation(Post post, List<HashTagDto.Request> hashTags){
//        List<HashTag> listOfHashTags = hashTagService.create(hashTags); // 게시글에서 사용하는 해시태그 생성
//
//        if (!listOfHashTags.isEmpty()) {
//            listOfHashTags.forEach(hashTag ->
//                    postTagService.create(post, hashTags));
//        }
//    }

    public PostDto.Response toDto(Post post) {
        Post pPost = find(post.getPostId());

        PostDto.Response postDto = PostDto.Response.builder()
                .postId(pPost.getPostId())
                .postedUser(userService.toDto(pPost.getPostedUser()))
                .content(pPost.getContent())
                .postedDate(pPost.getPostedDate())
                .postLike(pPost.getPostLike())
                .region(regionService.toDto(pPost.getRegion()))
                .tags(pPost.getPostTags().stream().map(postTag -> hashTagService.toDto(postTag.getHashTag())).collect(Collectors.toList()))
                .images(pPost.getImages().stream().map(imageService::toDto).collect(Collectors.toList()))
                .build();
        //postDto.setComments(commentService.findAll(post.getPostId()).stream().map(CommentService::toDto).collect(Collectors.toList()));
        return postDto;
    }
}
