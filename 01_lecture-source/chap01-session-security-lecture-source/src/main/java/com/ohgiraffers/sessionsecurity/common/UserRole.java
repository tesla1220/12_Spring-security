package com.ohgiraffers.sessionsecurity.common;

public enum UserRole {

    /* 필기
        enum 은 열거형 상수라고 한다.
        미리 정의된 상수값들의 집합인 클래스이며,
        하나의 집합으로서 반복문을 사용할 수 있으며
        컬렉션과 함께 사용할 수 있다.
        코드의 의미를 전달하는데 도움을 줄 수 있으며
     */

    // 필드에 상수를 하나씩 설정하면 상수들을 묶을 수 없다. 이 때 enum 을 사용해 묶을 수 있다.

    USER("USER"),
    ADMIN("ADMIN");

    private String role;

    UserRole(String role) {
        this.role = role;                           // 생성자
    }

    public String getRole() {
        return role;}

    @Override
    public String toString() {
        return "UserRole{" +
                "role='" + role + '\'' +
                '}';
    }
}


/*
Enum은 열거형(enumeration)의 준말로,
프로그래밍에서 고정된 상수 집합을 나타내는 데이터 형식입니다.
열거형은 서로 연관된 상수들의 집합을 정의하고 사용할 수 있도록 해줍니다.

Enum의 중요한 특징과 용도

1) 상수 그룹화:
Enum은 연관된 상수들을 그룹화하여 의미 있는 단위로 정의할 수 있습니다.
예를 들어, 요일을 나타내는 Enum은 일요일부터 토요일까지의 상수를 가질 수 있습니다.

2) 타입 안전성(Type Safety):
Enum은 컴파일 시점에 타입 안전성을 보장합니다.
즉, 올바르지 않은 값이 사용되는 것을 방지할 수 있습니다.

3) 의미 전달:
코드의 가독성을 높이고 의도를 명확히 전달할 수 있습니다.
예를 들어, "성별"을 나타내는 Enum은 "MALE"과 "FEMALE"과 같은 상수를 사용하여 성별을 명확하게 표현할 수 있습니다.

4) Switch 문과의 호환성:
Enum은 Switch 문과 함께 사용될 때 특히 유용합니다.
Switch 문에서 Enum의 모든 상수에 대한 처리를 간단하게 구현할 수 있습니다.
*/