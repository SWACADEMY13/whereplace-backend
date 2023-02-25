package com.cnu.swacademy.whereplace.domain.comment;

import com.cnu.swacademy.whereplace.domain.post.Post;
import com.cnu.swacademy.whereplace.domain.post.PostDto;
import com.cnu.swacademy.whereplace.domain.post.PostService;
import com.cnu.swacademy.whereplace.domain.user.User;
import com.cnu.swacademy.whereplace.domain.user.UserDto;
import com.cnu.swacademy.whereplace.domain.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Comment save(CommentDto.Request givenRequestCommentDto){
        Comment comment=toEntity(givenRequestCommentDto);
        User mappedUser=userService.find(givenRequestCommentDto.getCommentedUserId());
        Post mappedPost=postService.find(givenRequestCommentDto.getCommentedPostId());

        comment.setCommentedUser(mappedUser);
        comment.setPostComment(mappedPost);
        comment.setPostedDate(LocalDateTime.now());

        return commentRepository.save(comment);
    }

    public Comment toEntity(CommentDto.Request givenRequestUserDto) {
        return modelMapper.map(givenRequestUserDto, Comment.class);
    }

    public List<Comment> showAllComments(int postId){
        return null;
    }

    public Post read(int postId){ // 게시판 ID로 DB 조회 후 query 결과 가져옴
        return null;
    }

    public Post getPost(Post psot){
        return null;

    }

    public String update(PostDto postDTO){return null;}



    /******************** delete ***********************
     1. 게시판 ID로 DB 조회 후 삭제에 대한 service 실행(delete 등)
     2. 삭제결과 url 로 이동(게시글 목록 등)
     ***************************************************/

    @PostMapping("/delete-process")
    public void delete(int postId){}
}
