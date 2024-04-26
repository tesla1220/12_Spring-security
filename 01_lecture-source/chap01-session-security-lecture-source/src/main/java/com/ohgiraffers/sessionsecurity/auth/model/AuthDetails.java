package com.ohgiraffers.sessionsecurity.auth.model;

import com.ohgiraffers.sessionsecurity.user.model.dto.LoginUserDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AuthDetails implements UserDetails {

    private LoginUserDTO loginUserDTO;

    public AuthDetails() {}

    public AuthDetails(LoginUserDTO loginUserDTO) {
        this.loginUserDTO = loginUserDTO;
    }
    public LoginUserDTO getLoginUserDTO() {
        return loginUserDTO;
    }

    public void setLoginUserDTO(LoginUserDTO loginUserDTO) {
        this.loginUserDTO = loginUserDTO;
    }

    /* 필기
    *   getAuthorities() : 권한 정보를 반환하는 메소드
    *   UsernamePasswordAuthenticationToken 에 사용자의 권한 정보를 넣을 때 사용한다.
    *   다중 권한 처리 가능함  */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // getAuthorities() 메서드를 선언하고 있습니다.
        // 이 메서드는 사용자의 권한을 반환하는 데 사용됩니다.
        // 반환 타입은 Collection<? extends GrantedAuthority>으로,
        // GrantedAuthority 의 하위 타입을 포함하는 컬렉션을 반환합니다.

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        // authorities라는 이름의 ArrayList 객체를 생성합니다. 이 변수는 사용자의 권한을 저장하는 데 사용될 것입니다.

        loginUserDTO.getRole().forEach(role -> authorities.add(() -> role));
        // loginUserDTO 객체의 getRole() 메서드를 호출하여 사용자의 역할(Role) 목록을 가져옵니다.
        // 그런 다음, 이 목록을 반복(forEach)하면서 각 역할을 authorities 리스트에 추가(add())합니다.
        // 여기서 각 역할은 GrantedAuthority 인터페이스를 구현한 객체로 변환되어 리스트에 추가됩니다.

        return authorities;
        //  이 메서드는 authorities 리스트를 반환합니다. 이 리스트에는 사용자의 권한이 포함되어 있습니다.

    }


    /* 필기 : getPassword()
    *   사용자의 비밀번호를 반환하는 메소드
    *   UsernamePasswordAuthenticationToken 과 사용자의 비밀번호를 비교할 때 사용한다.  */
    @Override
    public String getPassword() {
        return loginUserDTO.getPassword();
    }


    /* 필기 : getUsername()
        사용자의 아이디를 반환하는 메소드
        UsernamePasswordAuthenticationToken 과 사용자의 아이디를 비교할 때 사용     */
    @Override
    public String getUsername() {
        return loginUserDTO.getUserName();
    }


    /* 필기 :  isAccountNonExpired()
        계정 만료 여부를 표현하는 메소드로 false 면 해당 계정을 사용할 수 없다.    */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /* 필기 :  isAccountNonLocked()
    *   잠겨있는 계정을 확인하는 메소드로 false 면 해당 계정을 사용할 수 없다.
    *   비밀번호 반복 실패로 일시적인 계정 lock 인 경우 혹은 오랜 시간 비접속으로 휴면 처리 */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }


    /* 필기
    *   탈퇴 계정 여부를 표현하는 메소드로 false 이면 해당 계정을 사용할 수 없다. */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    /* 필기
    *   계정 비활성화 여부로 사용자가 사용할 수 없는 상태 */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
