package com.cnu.swacademy.whereplace.domain.user;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/whereplace/user")
public class UserController {
    @PostMapping("/login-process")
    public void login(){}

    @PostMapping("/logout-process")
    public void logout(){}

    @PostMapping("/validation")
    public void validation(){}
}
