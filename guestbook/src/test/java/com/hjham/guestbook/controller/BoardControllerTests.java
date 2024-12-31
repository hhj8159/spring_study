package com.hjham.guestbook.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import jakarta.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

// @WebMvcTest()
@SpringBootTest
@AutoConfigureMockMvc
public class BoardControllerTests {
  // mock
  @Autowired
  private MockMvc mockMvc; 
  
  @BeforeEach
  public void init(WebApplicationContext ctx) {
    mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
  }
  @Test
  public void testTest() throws Exception{
    mockMvc.perform(get("/api/v1/board/test"))
    .andExpect(status().isOk())
    .andExpect(content().string("test"));
  }

  @Test
  public void testList() throws Exception{
    mockMvc.perform(get("/api/v1/board/list")
      .param("page", "3")
      .param("size", "5") 
      .param("type", "TC")
      .param("keyword", "8")
    )
    .andExpect(status().isOk())
    .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
  }

  @Test
  public void testRegister() throws Exception{
    String jsonStr = "" + //
    "{\r\n" + //
    "    \"title\" : \"컨트롤러 테스트 글등록\",\r\n" + //
    "    \"content\" : \"등록\",\r\n" + //
    "    \"memberEmail\" : \"a@b.c\"\r\n" + //
    "}";

    mockMvc.perform(post("/api/v1/board")
      .content(jsonStr)
      .contentType(MediaType.APPLICATION_JSON_VALUE)
    ).andDo(print()) ;
  }

}
