package com.hjham.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class PostDao {
  private JdbcTemplate jdbcTemplate;

  public int updateWriterNull(String id) {
    return jdbcTemplate.update("update tbl_posts set writer = Null where writer = ?", id);
  }
}
