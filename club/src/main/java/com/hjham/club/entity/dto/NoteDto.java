package com.hjham.club.entity.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NoteDto {
  private Long num;
  private String title;
  private String content;
  private String writerEmail;
  private Long mno;
  private LocalDateTime regDate, modDate;
}
