package com.cnu.swacademy.whereplace.domain.post;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/posts")
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

    @PostMapping("/write")
    public String create(@RequestBody PostDto.Request postDto){
        Post post = postService.create(postDto);

        return "redirect:/posts/" + post.getPostId();
    }

    /******************** read ***********************
     1. 게시판 ID로 DB 조회
     *************************************************/

    @GetMapping("/{postId}")
    public PostDto.Response read(@PathVariable int postId){ // 게시판 ID로 DB 조회 후 query 결과 가져옴
        Post post = postService.find(postId);

        return PostService.toDto(post);
    }

    /******************** update ***********************
     1. 게시판 ID로 DB 조회 후 query 결과로 "작성 단계 페이지"를 렌더링
     2. 작성 완료 버튼 누르면 수정에 대한 service 실행(update 등)
     3. 수정 후 렌더링
     ***************************************************/

    @PostMapping("/edit")
    public String update(@RequestBody PostDto.Request postDto){
        Post post = postService.update(postDto);

        return "redirect:/posts/" + post.getPostId();
    }

    /******************** delete ***********************
     1. 게시판 ID로 DB 조회 후 삭제에 대한 service 실행(delete 등)
     2. 삭제결과 url 로 이동(게시글 목록 등)
     ***************************************************/

    @DeleteMapping("/edit/delete")
    public String delete(int postId) {
        postService.delete(postId);

        return "redirect:/profiles/";
    }
}