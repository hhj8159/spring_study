package com.hjham.club.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hjham.club.entity.dto.NoteDto;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class NoteServiceTests {
  @Autowired
  private NoteService service;

  @Test
  @Transactional
  public void testGet() {
    log.info(service.get(1L));
  }

  @Test
  @Transactional
  public void testlist() {
    log.info(service.list("user100@hjham.com"));
  }

  @Test
  public void testWrite() {
    service.write(NoteDto.builder()
      .title("제목")
      .content("내용")
      .mno(100L)
      .writerEmail("user100@hjham.com")
    .build());
  }

  @Test
  public void testmodify() {
    service.write(NoteDto.builder()
      .num(8L)
      .title("제목")
      .content("내용2222222")
      .mno(100L)
      .writerEmail("user100@hjham.com")
    .build());
  }

  @Test
  public void testremove() {
    service.remove(8L);
  }
}
