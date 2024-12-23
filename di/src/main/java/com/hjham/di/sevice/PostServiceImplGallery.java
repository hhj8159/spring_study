package com.hjham.di.sevice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hjham.di.vo.Post;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service("gallery")
public class PostServiceImplGallery implements PostService{

    @Override
    public List<Post> list() {
        List<Post> list = new ArrayList<>();
        list.add(Post.builder().pno(3L).title("갤러리 게시판 제목").writer("작성자").build());
        list.add(Post.builder().pno(4L).title("갤러리 게시판 제목").writer("작성자").build());
        return list;
    }

    @Override
    public void wirte(Post post) {
        log.info(getClass().getSimpleName() + ".write() call");
    }
    
}
