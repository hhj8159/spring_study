package com.hjham.di.test;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.hjham.di.sevice.PostService;
import com.hjham.di.sevice.PostServiceImplNormal;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class PostTest {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(PostTest.class);
        ApplicationContext ctx = application.run(args);
        // ctx.refresh();
        PostService service = ctx.getBean(PostServiceImplNormal.class);
        service.list().forEach(log::info);
    }
}
