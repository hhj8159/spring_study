package com.hjham.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hjham.guestbook.domain.dto.GuestbookDto;
import com.hjham.guestbook.domain.dto.PageRequestDto;
import com.hjham.guestbook.domain.dto.PageResultDto;
import com.hjham.guestbook.domain.entity.Guestbook;
import com.hjham.guestbook.service.GuestbookService;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class GuestbookServiceTests {
  @Autowired
  private GuestbookService service;

  @Test
  public void testWrite() {
    GuestbookDto dto = GuestbookDto.builder()
    .title("서비스테스트제목")
    .content("서비스테스트내용")
    .writer("작성자")
    .build();

    Long gno = service.write(dto);
    assertNotNull(gno);
    log.info(dto);
  }

  @Test
  public void testList() {
    PageResultDto<GuestbookDto, Guestbook> dto = service.list(new PageRequestDto(2, 10));
    log.info(dto);
    dto.getPageList().forEach(log::info);
  }

  @Test
  public void testResultDto() {

  }
}
