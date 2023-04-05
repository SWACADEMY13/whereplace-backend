package com.cnu.swacademy.whereplace.domain.post_tag;


import com.cnu.swacademy.whereplace.domain.hashtag.HashTag;
import com.cnu.swacademy.whereplace.domain.hashtag.HashTagDto;
import com.cnu.swacademy.whereplace.domain.hashtag.HashTagService;
import com.cnu.swacademy.whereplace.domain.post.Post;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostTagService {

    private final HashTagService hashTagService;
    private final PostTagRepository postTagRepository;

    public PostTagService(HashTagService hashTagService, PostTagRepository postTagRepository) {
        this.hashTagService = hashTagService;
        this.postTagRepository = postTagRepository;
    }

    @Transactional
    public void create(Post post, List<HashTagDto.Request> hashTags){
        List<HashTag> listOfHashTags = hashTagService.create(hashTags); // 게시글에서 사용하는 해시태그 생성

        if (!listOfHashTags.isEmpty()) {
            listOfHashTags.forEach(hashTag -> {
                PostTag postTag = new PostTag(post, hashTag);
                postTagRepository.save(postTag);
                post.getPostTags().add(postTag);
            });
        }
    }

    @Transactional
    public void deleteAllByPostId(int postId) {
        postTagRepository.deleteAllByPost_PostId(postId);
    }

    public List<HashTagDto.Response> toDtos(List<PostTag> postTags) {
        return postTags.stream().map(postTag -> hashTagService.toDto(postTag.getHashTag())).collect(Collectors.toList());
    }
}
