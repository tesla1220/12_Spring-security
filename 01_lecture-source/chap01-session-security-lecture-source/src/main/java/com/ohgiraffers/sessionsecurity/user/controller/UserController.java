package com.ohgiraffers.sessionsecurity.user.controller;

import com.ohgiraffers.sessionsecurity.user.model.dto.SignupDTO;
import com.ohgiraffers.sessionsecurity.user.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;        // 필드 주입. 컨트롤러에서 userService를 호출하기 위해 의존성 주입

    @GetMapping("/signup")
    public void signup() {}     // user 폴더 하위 signup html 파일 리턴해줌

    @PostMapping("/signup")
    public ModelAndView signup(ModelAndView mv, @ModelAttribute SignupDTO signupDTO){

        int result = userService.regist(signupDTO);        // Mybatis 에서는 행의 값이 바뀌면 정수값을 리턴해줌

        String message = "";

        if(result > 0) {
            message = "회원가입이 정상적으로 완료되었습니다!";
        } else {
            message = "회원가입에 실패하셨습니다.";
        }

        mv.addObject("message", message);           // 위의 값을 ModelAndView 에 담아줌. 키값은 "message"

        return mv;
    }
}
