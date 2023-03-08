package com.cnu.swacademy.whereplace.domain.post;


import com.cnu.swacademy.whereplace.domain.hashtag.HashTagDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


// 주석은 개인적인 메모입니당

@Controller
@Slf4j
@RequestMapping("/whereplace/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    /******************** create ***********************
     1. 서버 사이드 렌더링 시, html 생성하여 제공
     2. 프론트 렌터링 시, JSON 제공
     *************************************************/

    @PostMapping("/create-process")
    public String create(@RequestBody PostDto.Request postDto){
        Post post = postService.save(postDto);
        List<HashTagDto.Request> hashTags = postDto.getHashTags();
        postService.createPostTagRelation(post,hashTags);
        // 해시태그 생성 및 중간 테이블 생성
        return "/whereplace/posts/view/" + post.getPostId();
    }


    /******************** read ***********************
     1. 게시판 ID로 DB 조회
     *************************************************/

    @GetMapping("/view/{postId}")
    public String read(@PathVariable String postId){ // 게시판 ID로 DB 조회 후 query 결과 가져옴
        return null;
    }



    /******************** update ***********************
     1. 게시판 ID로 DB 조회 후 query 결과로 "작성 단계 페이지"를 렌더링
     2. 작성 완료 버튼 누르면 수정에 대한 service 실행(update 등)
     3. 수정 후 렌더링
     ***************************************************/

    @PostMapping("/update-process")
    public String update(PostDto postDTO){return null;}



    /******************** delete ***********************
     1. 게시판 ID로 DB 조회 후 삭제에 대한 service 실행(delete 등)
     2. 삭제결과 url 로 이동(게시글 목록 등)
     ***************************************************/

    @PostMapping("/delete-process")
    public void delete(int postId){}

}