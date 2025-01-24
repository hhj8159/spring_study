package com.hjham.guestbook.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.hjham.guestbook.domain.dto.GuestbookDto;
import com.hjham.guestbook.domain.dto.PageRequestDto;
import com.hjham.guestbook.domain.dto.PageResultDto;
import com.hjham.guestbook.domain.entity.Guestbook;
import com.hjham.guestbook.service.GuestbookService;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class GuestbookServiceTests {
  @Autowired
  private GuestbookService service;

  @Test
  @DisplayName("글 작성 서비스 테스트")
  @Transactional
  // @Rollback(false)
  public void testWrite() {
    GuestbookDto dto = GuestbookDto.builder()
    .title("서비스 테스트 제목")
    .content("서비스 테스트 내용")
    .writer("작성자")
    .build();

    Long gno = service.write(dto);
    assertNotNull(gno);
  }

  @Test
  public void testList() {
    PageRequestDto dto = PageRequestDto.builder().page(1).size(10).type("TC").keyword("!제목").build();
    PageResultDto<GuestbookDto, Guestbook> resultDto = service.list(dto);
    log.info(resultDto);
    resultDto.getDtoList().forEach(log::info);
  }

  @Test
  public void testResultDto() {

  }
}
