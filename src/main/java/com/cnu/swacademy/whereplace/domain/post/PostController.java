package com.cnu.swacademy.whereplace.domain.post;


import com.cnu.swacademy.whereplace.domain.image.ImageDto;
import com.cnu.swacademy.whereplace.domain.post_image.PostImageDto;
import com.cnu.swacademy.whereplace.domain.region.RegionDto;
import com.cnu.swacademy.whereplace.domain.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


// 주석은 개인적인 메모입니당

@Controller
@RequestMapping("/whereplace/post")
public class PostController {

    @Autowired
    private PostService postService;

    /******************** create ***********************
     1. 서버 사이드 렌더링 시, html 생성하여 제공
     2. 프론트 렌터링 시, JSON 제공
     *************************************************/
//    @PostMapping("/new")
//    public HttpStatus createPost(PostDto.Request dto){ // 생성단계 (작성 단계 -> 작성 완료 버튼을 누를 때)
//        postService.save(dto);
//        return HttpStatus.OK; // 임시 반환값
//    }

    @GetMapping("/new")
    public String postUpload(){ // 생성단계 (작성 단계 -> 작성 완료 버튼을 누를 때)
        return "post"; // 임시 반환값
    }

    @PostMapping("/new")
    @ResponseBody
    public String createPost(String content){ // 생성단계 (작성 단계 -> 작성 완료 버튼을 누를 때)
        postService.save(PostDto.Request.builder()
                .postedUserDto(UserDto.Request.builder()
                        .email("test@gmail.com")
                        .name("홍길동")
                        .userId("test")
                        .password("test123")
                        .phone("01012345678")
                        .build())
                .content(content)
                .postedDate(LocalDateTime.now())
                .regionDto(RegionDto.Request.builder()
                        .regionName("대전")
                        .build())
                .build());
        return "저장 완료"; // 임시 반환값
    }


    /******************** read ***********************
     1. 게시판 ID로 DB 조회
     *************************************************/

    @GetMapping("/view/*")
    public String read(int postId){ // 게시판 ID로 DB 조회 후 query 결과 가져옴
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