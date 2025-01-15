package com.hjham.club.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.hjham.club.entity.Attach;
import com.hjham.club.entity.Note;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class AttachRepositoryTests {

  @Autowired
  private AttachRepository repository;

  @Test
  @Transactional
  @Rollback(false)
  public void testInsert() {
    for(int i = 0; i < 5; i++) {
      Attach attach = Attach.builder()
      .uuid("" + i)
      .origin("1.png")
      .note(Note.builder().num(1L).build())
      .build();

      repository.save(attach);
      
    }
  }

}
