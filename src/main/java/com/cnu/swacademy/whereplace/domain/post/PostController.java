package com.cnu.swacademy.whereplace.domain.post;

import com.cnu.swacademy.whereplace.domain.hashtag.HashTagDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequestMapping("/posts")
public class PostController { // test 완료

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @ResponseBody
    @GetMapping("/")
    public List<PostDto.Response> readAll() {
        List<Post> posts = postService.findAll();
        return posts.stream().map(postService::toDto).collect(Collectors.toList());
    }

    /******************** create ***********************
     1. 서버 사이드 렌더링 시, html 생성하여 제공
     2. 프론트 렌터링 시, JSON 제공
     *************************************************/

    @PostMapping("/write")
    public String create(@RequestBody PostDto.Request postDto){
        Post post = postService.create(postDto);

//        postService 의 create 랑 postTagService 의 create 에서 같은 동작을 수행하는 코드가 있어서 주석 처리 했습니다~!
//        List<HashTagDto.Request> hashTags = postDto.getHashTags();
//        if(hashTags!=null)
//            postService.createPostTagRelation(post,hashTags);

        return "redirect:/posts/" + post.getPostId();
    }

    /******************** read ***********************
     1. 게시판 ID로 DB 조회
     *************************************************/

    @ResponseBody
    @GetMapping("/{postId}")
    public PostDto.Response read(@PathVariable int postId) { // 게시판 ID로 DB 조회 후 query 결과 가져옴
        Post post = postService.findById(postId);

        return postService.toDto(post);
    }

    /******************** update ***********************
     1. 게시판 ID로 DB 조회 후 query 결과로 "작성 단계 페이지"를 렌더링
     2. 작성 완료 버튼 누르면 수정에 대한 service 실행(update 등)
     3. 수정 후 렌더링
     ***************************************************/

    @PostMapping("/{postId}/edit")
    public String update(@RequestBody PostDto.Request postDto) {
        Post post = postService.update(postDto);

        return "redirect:/posts/" + post.getPostId();
    }

    /******************** delete ***********************
     1. 게시판 ID로 DB 조회 후 삭제에 대한 service 실행(delete 등)
     2. 삭제결과 url 로 이동(게시글 목록 등)
     ***************************************************/

    @DeleteMapping("/{postId}/edit/delete") // 수정페이지에서 '삭제' 선택
    public String delete(@PathVariable int postId) {
        postService.delete(postId);

        return ""; // 프로필로 돌아가기, 나중에 URL 수정
    }
}