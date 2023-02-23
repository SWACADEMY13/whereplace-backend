package com.cnu.swacademy.whereplace.domain.image;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/whereplace/image/")
public class ImageController {

    @PostMapping("/upload-process")
    public void upload(){}


    // 기타 추가 작업 필요
}