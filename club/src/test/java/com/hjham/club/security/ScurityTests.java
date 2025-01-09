package com.hjham.club.security;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ScurityTests {
  @Autowired
  private PasswordEncoder passwordEncoder;

  @Test
  public void testEncoder() {
    log.info(passwordEncoder);
    log.info(passwordEncoder.getClass().getName());

    String pw = "1234";
    String encoded = passwordEncoder.encode(pw);

    log.info(pw);
    log.info(encoded);
    // $2a$10$gb78LgFmEEtZlZbB7i7FqeWRLFSdJQ0PaCgMv5AnQdQLbVpHF2Mxe
    // $2a$10$L/0rOpfCezEfCkp09iaFaOk1hOHVH5jpQ9VbyvPQQDyWRnkjfYJWu

    assertTrue(passwordEncoder.matches(pw, "$2a$10$L/0rOpfCezEfCkp09iaFaOk1hOHVH5jpQ9VbyvPQQDyWRnkjfYJWu"));
    assertTrue(passwordEncoder.matches(pw, "$2a$10$gb78LgFmEEtZlZbB7i7FqeWRLFSdJQ0PaCgMv5AnQdQLbVpHF2Mxe"));
  }
}
