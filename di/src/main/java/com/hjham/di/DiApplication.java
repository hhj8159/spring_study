package com.hjham.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;


@SpringBootApplication
// bean 쓰려면 아래 3개 중 하나가 필요함
// @Component
// @Service
// @Controller

// bean 대상 추적  (basePackages 알아둘 것)
// @ComponentScan(basePackages = "com.hjham.di") 

public class DiApplication {

	// 대상 메서드를 bean으로 만들어 줌 반환대상이 인터페이스면 빈이 된다

	public static void main(String[] args) {
		SpringApplication.run(DiApplication.class, args);
	}

}
