package com.hjham.guestbook.repository;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.hjham.guestbook.domain.entity.Board;
import com.hjham.guestbook.domain.entity.Member;
import com.hjham.guestbook.domain.entity.Reply;

import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ReplyRepositoryTests {
  @Autowired
  private ReplyRepository repository;

  @Test
  public void testExist() {
    log.info(repository);
  }

  @Test
  @Transactional
  // @Rollback(false)
  public void testInsert() {
    IntStream.rangeClosed(2, 100).forEach(i -> {
      Reply reply = Reply.builder()
      .text("text" + "1234")
      .replyer("replyer" + i)
      .board(Board.builder().bno(0L+((int)(Math.random() * 99)+1)).build())
      .build();
      repository.save(reply);
    });
  }

  @Test
  public void testSelectList() {
    // repository.findAll().forEach(log::info);
  }

  @Test
  public void testSelectOne() {
    Reply reply = repository.findById(1L).orElse(null);
    log.info(reply);
    // 댓글의 작성글의 작성자 이름 출력
    log.info(reply.getBoard().getMember().getName());
  }

  @Test
  public void testModify() {

  }

  @Test
  public void testQuerydsl() {
  }

  
  
 
}
