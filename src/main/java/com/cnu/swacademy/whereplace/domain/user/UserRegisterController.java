package com.cnu.swacademy.whereplace.domain.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserRegisterController {

    private final UserService userService;

    public UserRegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/whereplace/register-process")
    public String register(UserDto.REQUEST requestUserDto){  // 정규식은 미적용
        User user=userService.getUserDto(requestUserDto);
        userService.save(user);
        return "redirect:/index.html";
    }
}
