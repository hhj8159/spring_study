package com.hjham.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReplyDao {
  private JdbcTemplate jdbcTemplate;

  public int updateWriterNull(String id) {
    return jdbcTemplate.update("update tbl_reply set writer = Null where writer = ?", id);
  }
}
