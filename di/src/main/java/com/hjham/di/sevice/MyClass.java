package com.hjham.di.sevice;

import java.util.stream.Stream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hjham.di.vo.Post;

@Configuration
public class MyClass {

    @Bean
    public PostService postService() {
        return () -> Stream.of(Post.builder().pno(7L).title("익명").build()).toList();
    }
}
