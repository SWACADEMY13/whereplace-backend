package com.cnu.swacademy.whereplace.domain.comment;


import com.cnu.swacademy.whereplace.domain.post.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/whereplace")
public class CommentController {

    @Autowired
    private CommentService commentService;


    /******************** create ***********************
     1. 서버 사이드 렌더링 시, html 생성하여 제공(타임리프)
     2. 프론트 렌터링 시, JSON 제공
     *************************************************/
    @PostMapping("/comments/create-process")
    public String create(CommentDto.Request givenRequestCommentDto){ // 생성단계 (작성 단계 -> 작성 완료 버튼을 누를 때)
        return "/posts/view/"+commentService.save(givenRequestCommentDto).getPostComment().getPostId();
    }

    /******************** read ***********************
     1. 게시판 ID로 DB 조회
     *************************************************/

    @ResponseBody
    @GetMapping("/comments/read")
    public List<Comment> loadAll(PostDto.Request givenRequestPostDto){
        return commentService.findAll(givenRequestPostDto.getPostId());
    }

    /******************** update ***********************
     1. 게시판 ID로 DB 조회 후 query 결과로 "작성 단계 페이지"를 렌더링
     2. 작성 완료 버튼 누르면 수정에 대한 service 실행(update 등)
     3. 수정 후 렌더링
     ***************************************************/

    @PostMapping("/comments/{commentId}/update-process")
    public String modify(CommentDto.Request givenRequestCommentDTO){
        return "/posts/view/"+commentService.update(givenRequestCommentDTO).getPostComment().getPostId();
    }


    /******************** delete ***********************
     1. 게시판 ID로 DB 조회 후 삭제에 대한 service 실행(delete 등)
     2. 삭제결과 url 로 이동(게시글 목록 등)
     ***************************************************/

    @PostMapping("/view/{postId}/comments/{commentId}/delete-process/")
    public String delete(@PathVariable int postId,@PathVariable int commentId){
        commentService.delete(commentId);
        return "/posts/view/"+postId;
    }
}
