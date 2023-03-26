package com.cnu.swacademy.whereplace.domain.user;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Controller
@Slf4j
@RequestMapping("/whereplace/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login-process")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpServletResponse response, HttpSession session) {
        Optional<User> user = userService.login(username, password);

        if (user.isPresent()) { // 로그인 성공 시
            Cookie cookie=new Cookie("user_session_id",session.getId());
            cookie.setAttribute("username",user.get().getUsername());
            cookie.setMaxAge(1000*60*10); // 1000ms * 60 * 10 = 10m
            session.setMaxInactiveInterval(60*10); // 60s * 10 =10m
            response.addCookie(cookie);
            log.info("Login Success: "+user.get().getUsername());

            return "redirect:/index.html";
        }


        log.info("Login Failed");

        return "redirect:/login.html";
    }

    @PostMapping("/logout-process")
    public String logout(HttpServletResponse response,Model model,HttpSession session) {
        Cookie cookie=new Cookie("user_session_id",null);
        cookie.setAttribute("username",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        session.setMaxInactiveInterval(0);

        return "/whereplace/main";
    }
}