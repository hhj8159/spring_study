package com.hjham.guestbook.repository;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.hjham.guestbook.domain.entity.Member;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class MemberRepositoryTests {
  @Autowired
  private MemberRepository repository;

  @Test
  public void testExist() {
    log.info(repository);
  }

  @Test
  @Transactional
  // @Rollback(false)
  public void testInsert() {
    // Member member = Member.builder()
    // .email("a@b.c")
    // .password("1234")
    // .name("새똥이")
    // .build();
    // repository.save(member);

    IntStream.rangeClosed(2, 100).forEach(i -> {
      Member member = Member.builder()
      .email("user" + i + "@a.com")
      .password("1234")
      .name("user" + i)
      .build();
      repository.save(member);
    });
  }

  @Test
  public void testSelectList() {
    // repository.findAll().forEach(log::info);
  }

  @Test
  public void testSelectOne() {
  }

  @Test
  public void testModify() {

  }

  @Test
  public void testQuerydsl() {
  }

  
  
 
}
