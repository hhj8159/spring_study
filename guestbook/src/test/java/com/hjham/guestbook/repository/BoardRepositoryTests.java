package com.hjham.guestbook.repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.hjham.guestbook.domain.entity.Board;
import com.hjham.guestbook.domain.entity.Member;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {
  @Autowired
  private BoardRepository repository;

  @Test
  public void testExist() {
    log.info(repository);
  }

  @Test
  @Transactional
  // @Rollback(false)
  public void testInsert() {
    IntStream.rangeClosed(2, 100).forEach(i -> {
      Board board = Board.builder()
      .title("title" + i)
      .content("content" + "1234")
      .member(Member.builder().email("user" + i + "@a.com").build())
      .build();
      repository.save(board);
    });
  }

  @Test
  public void testSelectList() {
    // repository.findAll().forEach(log::info);
  }

  @Test
  @Transactional
  public void testSelectOne() {
    Board board = repository.findById(2L).get();
    log.info(board);

    log.info(board.getMember());
  }

  @Test
  public void testGetBoardWithMember() {
    Object result = repository.getBoardWithMember(2L);
    Object[] arr = (Object[]) result;
    log.info(Arrays.toString(arr));
  }
  @Test
  public void testGetBoardWithReply() {
    List<Object[]> result = repository.getBoardWithReply(5L);
    result.forEach(arr -> log.info(Arrays.toString(arr)));
  }
  
  @Test
  public void tesGetBoardWithReplyCount() {
    Pageable pageable = PageRequest.of(0,10,Sort.by(Direction.DESC, "bno"));
    Page<Object[]> result = repository.getBoardWithReplyCount(pageable);
    result.forEach(arr -> log.info(Arrays.toString(arr)));
  }
  
  @Test
  public void testGetBoardByBno() {
    Object[] arr = repository.getBoardByBno(5L);
    log.info(Arrays.toString(arr));
  }

  @Test
  public void testModify() {

  }

  @Test
  public void testQuerydsl() {
  }

  
  
 
}
