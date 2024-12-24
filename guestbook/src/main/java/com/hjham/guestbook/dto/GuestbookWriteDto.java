package com.hjham.guestbook.dto;

import java.time.LocalDateTime;

import com.hjham.guestbook.domain.entity.GuestbookEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuestbookWriteDto {
  private String title;
  private String content;
  private String writer;

  
  public GuestbookEntity toEntity() {
    return GuestbookEntity.builder()
    .title(title)
    .content(content)
    .writer(writer)
    .build();
  }
}
