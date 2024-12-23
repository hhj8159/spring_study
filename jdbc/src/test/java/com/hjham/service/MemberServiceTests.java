package com.hjham.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;

import com.hjham.jdbc.service.MemberService;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class MemberServiceTests {
  @Autowired
  private MemberService memberService;

  @Test
  public void testQuit() {
    try {
      memberService.quitMember("abcde");
    }
    catch(DataAccessException e) {
      log.error(e.getMessage());
    }
  }
  
}