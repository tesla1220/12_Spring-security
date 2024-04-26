package com.ohgiraffers.sessionsecurity.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ohgiraffers.sessionsecurity", annotationClass = Mapper.class)
public class MybatisConfig {
}

//  basePackages 속성은 매퍼 인터페이스가 위치한 패키지의 경로를 지정합니다.
//  annotationClass 속성은 매퍼 인터페이스를 식별하는 데 사용되는 어노테이션 클래스를 지정합니다.
//  여기서는 Mapper라는 어노테이션 클래스를 사용하여 매퍼 인터페이스를 식별합니다.
// 따라서 이 코드는 "com.ohgiraffers.sessionsecurity" 패키지 내의 모든 매퍼 인터페이스를 찾아 MyBatis에게 등록하도록 지시합니다.
// MyBatis는 이러한 매퍼 인터페이스를 사용하여 SQL 쿼리를 실행하는 메서드를 동적으로 생성하고,
// 이를 통해 데이터베이스와 상호작용할 수 있습니다.
