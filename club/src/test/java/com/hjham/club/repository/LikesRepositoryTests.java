package com.hjham.club.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import com.hjham.club.entity.Likes;
import com.hjham.club.entity.Member;
import com.hjham.club.entity.Note;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class LikesRepositoryTests {
  @Autowired
  private LikesRepository repository;

  @Test
  public void testLike() {
    log.info(repository);
  }

  @Test
  public void testInsert() {
    Likes likes = Likes.builder()
      .member(Member.builder().mno(100L) .build())
      .note(Note.builder().num(1L) .build())
    .build();
    repository.save(likes);
  }

  @Test
  public void testDelete() {
    repository.delete(Likes.builder()
      .member(Member.builder().mno(100L) .build())
      .note(Note.builder().num(1L) .build())
    .build());
  }

  @Test
  public void testCountByNum() {
    repository.count(Example.of(Likes.builder().note(Note.builder().num(1L).build()).build()));
  }

  

}
