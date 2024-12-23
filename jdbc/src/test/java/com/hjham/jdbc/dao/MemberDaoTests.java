package com.hjham.jdbc.dao;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Answers.valueOf;

import java.util.Date;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hjham.jdbc.vo.Member;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class MemberDaoTests {
  @Autowired
  private MemberDao dao;

  @Test
  public void testGetTime() {
    log.info(dao.getTime());
  }
  
  @Test
  public void testRegister() {
    Member member = Member.builder().id("abcde").pw("1234").name("스프링부트").build();
    dao.register(member);
  }

  @Test
  public void testList() {
    dao.selectList().forEach(log::info);
  }
  
  @Test
  public void testOne() {
    log.info(dao.selectOne("abcd"));  
  }

  @Test
  public void testObject() {
    Object o = null;
    try {
      String s = (String)o;
      Long l = Long.valueOf(s);
      log.info(l + 2000);
    }
    catch(ClassCastException e) {
      log.info("cast 과정의 문제");
    }
    catch(NumberFormatException e) {
      log.info("문자열이지만 숫자로 구성되어 있지 않음");
    }

  }
  @Test
  public void testUpdate() {
    Member member = dao.selectOne("abcd");
    log.info(member);
    member.setRoad_addr("디지털로 306");
    member.setDetail_addr("2층 더조은 아카데미");
    member.setEmail("saeddong@naver.com");
    int result = dao.update(member);
    assertEquals(1, result);

    log.info(dao.selectOne("abcd"));
  }

  @Test
  public void testDelete() {
    assertEquals(1, dao.delete("abcde"));
  }
}