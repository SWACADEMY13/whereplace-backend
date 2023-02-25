package com.cnu.swacademy.whereplace.domain.user;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;


@Controller
@Slf4j
@RequestMapping("/whereplace/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login-process")
    public String login(@RequestParam String userId,
                        @RequestParam String password,
                        HttpServletResponse response, HttpSession session) {
        Optional<User> user = userService.login(userId, password);

        if (user.isPresent()) { // 로그인 성공 시
            Cookie cookie=new Cookie("user_session_id",session.getId());
            cookie.setAttribute("user_id",user.get().getUserId());
            cookie.setMaxAge(1000*60*10); // 1000ms * 60 * 10 = 10m
            session.setMaxInactiveInterval(60*10); // 60s * 10 =10m
            response.addCookie(cookie);
            log.info("Login Success: "+user.get().getUserId());

            return "redirect:/index.html";
        }


        log.info("Login Failed");

        return "redirect:/login.html";
    }

    @PostMapping("/logout-process")
    public String logout(HttpServletResponse response,Model model,HttpSession session) {
        Cookie cookie=new Cookie("user_session_id",null);
        cookie.setAttribute("user_id",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        session.setMaxInactiveInterval(0);

        return "/whereplace/main";
    }
}
