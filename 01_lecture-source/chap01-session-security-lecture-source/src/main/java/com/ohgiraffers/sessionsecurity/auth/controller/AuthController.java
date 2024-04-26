package com.ohgiraffers.sessionsecurity.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public void login() {}          // "/auth/login" 요청이 왔을 때 auth 하위의 login html 파일을 뷰로 보여줌

    @GetMapping("/fail")
    public ModelAndView loginFail(ModelAndView mv, @RequestParam String message) {
        // 이 메서드는 ModelAndView 객체와 message 라는 문자열 매개변수를 받습니다.
        // 이 메서드는 로그인 실패 시 호출되며, 사용자에게 실패 메시지를 보여줍니다.

        mv.addObject("message", message);
        //  "message"라는 키로 받은 메시지를 ModelAndView 객체에 추가합니다.
        //  이렇게 함으로써 뷰에서 이 값을 사용할 수 있습니다.

        mv.setViewName("/auth/fail");
        // setViewName 메서드는 뷰의 이름을 설정합니다.
        // "/auth/fail"로 설정되어 있으므로, 이 메서드는 "/auth/fail"이라는 뷰를 보여줄 것입니다.


        return mv;
        //  ModelAndView 객체를 반환합니다. 이 객체에는 뷰에 전달할 데이터와 뷰 이름이 포함되어 있습니다
    }
}
