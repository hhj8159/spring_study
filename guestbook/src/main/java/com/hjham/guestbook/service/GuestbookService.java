package com.hjham.guestbook.service;

import java.util.List;

import com.hjham.guestbook.domain.dto.GuestbookDto;
import com.hjham.guestbook.domain.dto.GuestbookListDto;
import com.hjham.guestbook.domain.dto.GuestbookModifyDto;
import com.hjham.guestbook.domain.dto.GuestbookViewDto;
import com.hjham.guestbook.domain.dto.PageRequestDto;
import com.hjham.guestbook.domain.dto.PageResultDto;
import com.hjham.guestbook.domain.entity.Guestbook;

public interface GuestbookService {
  Long write(GuestbookDto dto);
  PageResultDto<GuestbookDto, Guestbook> list(PageRequestDto dto);

  void modify(GuestbookModifyDto dto);
  void remove(Long gno);

  GuestbookViewDto get(Long gno);

  // 구상 default, static
  default Guestbook toEntity(GuestbookDto dto) {
    return Guestbook.builder()
    .gno(dto.getGno())
    .title(dto.getTitle())
    .content(dto.getContent())
    .writer(dto.getWriter())
    .build();
  }

  // entity >>> dto 변환 메서드 정의 (parameter입력 return출력)
  default GuestbookDto toDto(Guestbook en) {
    return GuestbookDto.builder()
    .gno(en.getGno())
    .title(en.getTitle())
    .content(en.getContent())
    .writer(en.getWriter())
    .regDate(en.getRegDate())
    .modDate(en.getModDate())
    .build();
  }

  
}
