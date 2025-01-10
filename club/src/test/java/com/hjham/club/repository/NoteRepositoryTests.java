package com.hjham.club.repository;

import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.hjham.club.entity.Member;
import com.hjham.club.entity.Note;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
@Transactional
public class NoteRepositoryTests {
  @Autowired
  private NoteRepository repository;

  @Test
  public void testExist() {
    log.info(repository);
  }

  @Test
  @Rollback(false)
  public void testSave() {
    LongStream.rangeClosed(1, 5).boxed().map(l ->
      Note.builder()
      .title("제목" + l)
      .content("내용" + l)
      .member(Member.builder().mno(100L).build())
      .build()
    ).forEach(repository::save);    
  }

  @Test
  public void testOne() {
    Note note = repository.findByNum(1L);
    log.info(note);  
    log.info("======================");
    log.info(note.getMember().getEmail());
    
  }

  @Test
  public void testList() {
    repository.findByMemberMno(100L).forEach(log::info);
  }

  @Test
  public void testList2() {
    repository.findByMemberEmail("user100@hjham.com").forEach(log::info);
  }


}
