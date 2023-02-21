package com.cnu.swacademy.whereplace.domain.user;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/whereplace/register")
public class UserRegisterController {

    @PostMapping("/register-process")
    public void register(){}

}
