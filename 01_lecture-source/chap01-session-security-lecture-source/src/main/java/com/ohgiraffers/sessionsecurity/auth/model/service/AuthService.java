package com.ohgiraffers.sessionsecurity.auth.model.service;

import com.ohgiraffers.sessionsecurity.auth.model.AuthDetails;
import com.ohgiraffers.sessionsecurity.user.model.dto.LoginUserDTO;
import com.ohgiraffers.sessionsecurity.user.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService implements UserDetailsService {

    /* 필기 : UserDetailsService
    *   security 에서 사용자의 아이디를 인증하기 위한 interface
    *   loadUserByName 을 필수로 구현해야 하며,
    *   로그인 시 해당 메소드에 login 요청 시 전달된 사용자의 id를 매개변수로 DB 에서 조회를 한다. */

    @Autowired
    private UserService userService;        // 사용자와 관련된 것은 하기 service 폴더 내의 UserService 에 묶어놓음

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // loadUserByUsername : 사용자의 ID를 지칭. 매개변수로 사용 중인 username 과 다르다

        LoginUserDTO login = userService.findByUsername(username);       // 매개변수 username 으로 LoginUserDTO에 있는 값 찾으러 감


        if(Objects.isNull(login)) {         // = login 이란 객체가 없다면
            throw new UsernameNotFoundException("해당하는 회원 정보가 존재하지 않습니다.");
        }

        return new AuthDetails(login);
    }
}
