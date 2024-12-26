package com.hjham.guestbook.domain.dto;

import java.time.LocalDateTime;

import com.hjham.guestbook.domain.entity.Guestbook;

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
public class GuestbookListDto {
  private Long gno;
  private String title;
  private String content;
  private String writer;
  private LocalDateTime regDate;
  private LocalDateTime modDate;

  public GuestbookListDto(Guestbook entity) {
    this.gno = entity.getGno();
    this.title = entity.getTitle();
    this.content = entity.getContent();
    this.writer = entity.getWriter();
    this.regDate = entity.getRegDate();
    this.modDate =entity.getModDate();

  }


}
