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
    private UserService userService;        // 필드 주입. 컨트롤러에서 userService 를 호출하기 위해 의존성 주입

    @GetMapping("/signup")
    public void signup() {}     // user 폴더 하위 signup html 파일 리턴해줌

    @PostMapping("/signup")
    public ModelAndView signup(ModelAndView mv, @ModelAttribute SignupDTO signupDTO){
        // 이 메서드는 ModelAndView 객체와 SignupDTO 객체를 매개변수로 받습니다.
        // 클라이언트에서 전송된 데이터는 SignupDTO 객체로 바인딩됩니다.

        int result = userService.regist(signupDTO);        // Mybatis 에서는 행의 값이 바뀌면 정수값을 리턴해줌
        // userService 객체의 regist 메서드를 호출하여 회원가입을 처리합니다.
        // 이 메서드는 signupDTO 객체에 포함된 정보를 사용하여 회원가입을 수행하고, 그 결과를 정수형으로 반환합니다.

        String message = "";
        // 회원가입 결과에 따라 사용자에게 보여줄 메시지를 저장할 변수를 초기화합니다.

        if(result > 0) {
            message = "회원가입이 정상적으로 완료되었습니다!";
        } else {
            message = "회원가입에 실패하셨습니다.";
        }
        // result 변수가 양수인 경우 "회원가입이 정상적으로 완료되었습니다!" 메시지를,
        // 그렇지 않은 경우 "회원가입에 실패하셨습니다." 메시지를 message 변수에 할당합니다.

        mv.addObject("message", message);           // 위의 값을 ModelAndView 에 담아줌. 키값은 "message"
        //: "message"라는 키로 message 값을 ModelAndView 객체에 추가합니다.
        // 이렇게 함으로써 뷰에서 이 값을 사용할 수 있습니다.

        return mv;
        // 처리 결과와 함께 ModelAndView 객체를 반환합니다.
        // 이 객체에는 뷰에 전달할 데이터와 뷰 이름이 포함되어 있습니다.
    }
}
