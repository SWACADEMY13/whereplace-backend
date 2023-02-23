package com.cnu.swacademy.whereplace.domain.comment;

import com.cnu.swacademy.whereplace.domain.post.Post;
import com.cnu.swacademy.whereplace.domain.post.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public String create(PostDto postDTO){ // 생성단계 (작성 단계 -> 작성 완료 버튼을 누를 때)
        return null;
    }
//
//    public List<Comment> showAllComments(int postId){
//        List<Comment> comments=commentRepository.findAllById();
//    }
//
//    public Post read(int postId){ // 게시판 ID로 DB 조회 후 query 결과 가져옴
//    }

//    public Post getPost(Post)

    public String update(PostDto postDTO){return null;}



    /******************** delete ***********************
     1. 게시판 ID로 DB 조회 후 삭제에 대한 service 실행(delete 등)
     2. 삭제결과 url 로 이동(게시글 목록 등)
     ***************************************************/

    @PostMapping("/delete-process")
    public void delete(int postId){}
}