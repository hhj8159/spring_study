package com.hjham.di.sevice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hjham.di.vo.Post;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service("normal")
public class PostServiceImplNormal implements PostService{

    @Override
    public List<Post> list() {
        List<Post> list = new ArrayList<>();
        list.add(Post.builder().pno(1L).title("일반 게시판 제목").writer("작성자").build());
        list.add(Post.builder().pno(2L).title("일반 게시판 제목").writer("작성자").build());
        return list;
    }

    @Override
    public void wirte(Post post) {
        log.info(getClass().getSimpleName() + ".write() call");
    }
    
}
