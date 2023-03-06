package com.cnu.swacademy.whereplace.domain.hashtag;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/whereplace/hashtags")
public class HashTagController {

    private final HashTagService hashTagService;

    public HashTagController(HashTagService hashTagService) {
        this.hashTagService = hashTagService;
    }

    @PostMapping("/create-process")
    public String create(Model model, @RequestBody List<HashTagDto.Request> hashTags){
        hashTagService.save(hashTags);
        model.addAttribute("hashTags",hashTagService.findHashTagIdAll(hashTags));
        return "/whereplace/";
    }
}
