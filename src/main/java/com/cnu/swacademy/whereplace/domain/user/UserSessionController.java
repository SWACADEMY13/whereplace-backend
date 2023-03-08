package com.cnu.swacademy.whereplace.domain.user;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

@Slf4j
@Controller
@RequestMapping(value = "/", headers = "Cache-Control=no-cache, no-store, must-revalidate")
public class UserSessionController {
    public void reminder(HttpServletRequest request, HttpServletResponse response,HttpSession session){ // 페이지 로드마다 로그인 상태를 갱신
        if(Objects.equals(request.getRequestedSessionId(), session.getId())){
            response.setHeader("isLogin","true");
            log.info("Keep login session for user");
            return;
        }

        log.info("Session Expired");
    }
}