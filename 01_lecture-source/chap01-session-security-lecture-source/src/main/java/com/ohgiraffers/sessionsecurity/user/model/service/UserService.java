package com.ohgiraffers.sessionsecurity.user.model.service;

import com.ohgiraffers.sessionsecurity.user.model.dao.UserMapper;
import com.ohgiraffers.sessionsecurity.user.model.dto.LoginUserDTO;
import com.ohgiraffers.sessionsecurity.user.model.dto.SignupDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {      //  컨트롤러까지는 아직 비밀번호가 암호화 처리 되지 않았음. 실제로 데이터베이스와 접근하는 서비스 계층에서 비밀번호 암호화 처리

    @Autowired
    private UserMapper userMapper;          // userMapper (인터페이스)를 사용하기 위해 의존성 주입. 하단에 사용하고 있음

    @Autowired
    private PasswordEncoder passwordEncoder;

    public int regist(SignupDTO signupDTO) {

        signupDTO.setUserPass(passwordEncoder.encode(signupDTO.getUserPass()));

        int result = 0;

        try {
            result = userMapper.regist(signupDTO);      //signupDTO를 넘기면서 Mapper를 호출
        } catch (Exception e) {
            e.printStackTrace();          // printStackTrace: 예외가 발생했을 때, 발생한 위치와 상태를 반환하는 메소드
        }

        // try 구문 먼저 실행 후 예외가 발생할 때 catch 안의 내용 수행

        return result;

    }

    public LoginUserDTO findByUsername(String username) {

        LoginUserDTO login = userMapper.findByUsername(username);

        if(!Objects.isNull(login)){
            return login;
        } else {
            return null;
        }
    }
}
