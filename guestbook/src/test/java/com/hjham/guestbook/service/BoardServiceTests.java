package com.hjham.guestbook.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hjham.guestbook.domain.dto.BoardDto;
import com.hjham.guestbook.domain.dto.PageRequestDto;
import com.hjham.guestbook.domain.dto.PageResultDto;
import com.hjham.guestbook.domain.entity.Board;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardServiceTests {
  @Autowired
  private BoardService service;

  @Test
  public void testGet() {
    Long bno = 1L;
    log.info(service.get(bno));
  }

  @Test
  public void testRegister() {
    // given(주어진 값)
    BoardDto dto = BoardDto.builder().title("서비스 테스트 제목").content("내용")
    .memberEmail("user4@a.com").build();

    // when
    Long result = service.register(dto);

    // then
    assertNotNull(result);
  }

  @Test
  public void testList() {
    PageResultDto<BoardDto, Object[]> dto = service.list(PageRequestDto.builder().page(1).size(10).build());
    log.info(dto);
    dto.getDtoList().forEach(log::info);
  }  

  @Test
  public void testModify() {
    BoardDto dto = service.get(1L);
    dto.setMemberEmail("user95@a.com");

    service.modify(dto);
  }
}
