package com.hjham.club;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.log4j.Log4j2;


@SpringBootTest
@Log4j2
public class GlobalTests {
  @Value("${aws.s3.access-key}")
  private String accessKey;

  @Test
  public void accesskeyTest() {
    log.info(accessKey);
  }
}
