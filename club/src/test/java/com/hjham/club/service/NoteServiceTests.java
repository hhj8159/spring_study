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
      .title("제목0113")
      .content("내용0113")
      .mno(100L)
      .writerEmail("user100@hjham.com")
    .build());
  }

  @Test
  public void testmodify() {
    service.modify(NoteDto.builder()
      .num(5L)
      .title("제목수정1")
      .content("내용수정1")
      .mno(101L)
      .writerEmail("hhj8159@gmail.com")
    .build());
  }

  @Test
  public void testremove() {
    service.remove(11L);
  }
}
