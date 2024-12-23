package com.hjham.di.sevice;

import java.util.List;

import com.hjham.di.vo.Post;

public interface PostService {
    default void wirte(Post post) {
        
    }
    List<Post> list();
}
