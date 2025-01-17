package com.hjham.club.entity.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder.Default;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NoteDto {
  private Long num;
  private String title;
  private String content;
  private String memberEmail;
  private Long mno;
  private LocalDateTime regDate, modDate;

  private long likesCnt;
  private long attachCnt;

  @Default
  private List<AttachDto> attachDtos = new ArrayList<>();
}
