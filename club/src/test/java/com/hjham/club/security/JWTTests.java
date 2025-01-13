package com.hjham.club.security;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.hjham.club.security.util.JWTUtil;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class JWTTests {
  private JWTUtil jwtUtil;

  @BeforeEach
  public void init() {
    jwtUtil = new JWTUtil();
  }

  @Test
  public void testCreate() throws Exception {
    String email = "user100@hjham.com";
    String str = jwtUtil.generateToken(email);
    log.info(str);

    //eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE3MzY3NTE0ODIsImV4cCI6MTczOTQyOTg4Miwic3ViIjoidXNlcjEwMEBoamhhbS5jb20ifQ.HCC_RxbRRdo1beoZzKbzDH1DITwFrV6ZLExKhxGFwp8
  }
  
  @Test
  public void testExtract() throws Exception {
    String email = "user100@hjham.com";
    String token = jwtUtil.generateToken(email);

    Thread.sleep(5000);

    String resultEmail = jwtUtil.validateExtract(token);

    log.info(resultEmail);

    assertEquals(email, resultEmail);

  }




}
