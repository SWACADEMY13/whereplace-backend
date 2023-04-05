package com.cnu.swacademy.whereplace.domain.comment;


import com.cnu.swacademy.whereplace.domain.post.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/posts/{postId}/comments") // url 이 이렇게 되는 게 더 자연스러운 것 같아서 일단 수정해봤습니다!
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    /******************** create ***********************
     1. 서버 사이드 렌더링 시, html 생성하여 제공(타임리프)
     2. 프론트 렌터링 시, JSON 제공
     *************************************************/
    @PostMapping("/write")
    public String create(@RequestBody CommentDto.Request givenRequestCommentDto){ // 생성단계 (작성 단계 -> 작성 완료 버튼을 누를 때)
        return "redirect:/posts/" + commentService.create(givenRequestCommentDto).getCommentedPost().getPostId();
    }

    /******************** read ***********************
     1. 게시판 ID로 DB 조회
     *************************************************/

//    @ResponseBody
//    @GetMapping("/comments/read") // 댓글은 게시글 조회에 같이 조회해야 돼서 따로 URL 요청이 필요할 것 같진 않아서 주석처리 했습니당
//    public List<Comment> loadAll(PostDto.Request givenRequestPostDto){
//        return commentService.findAll(givenRequestPostDto.getPostId());
//    }

    /******************** update ***********************
     1. 게시판 ID로 DB 조회 후 query 결과로 "작성 단계 페이지"를 렌더링
     2. 작성 완료 버튼 누르면 수정에 대한 service 실행(update 등)
     3. 수정 후 렌더링
     ***************************************************/

    @PostMapping("/{commentId}/edit")
    public String update(@RequestBody CommentDto.Request givenRequestCommentDTO){
        return "redirect:/posts/" + commentService.update(givenRequestCommentDTO).getCommentedPost().getPostId();
    }


    /******************** delete ***********************
     1. 게시판 ID로 DB 조회 후 삭제에 대한 service 실행(delete 등)
     2. 삭제결과 url 로 이동(게시글 목록 등)
     ***************************************************/

    @DeleteMapping("/{commentId}/edit/delete/")
    public String delete(@PathVariable int postId, @PathVariable int commentId){
        commentService.delete(commentId);
        return "redirect:/posts/" + postId;
    }
}