package com.hjham.guestbook.service;

import java.util.List;

import com.hjham.guestbook.domain.dto.GuestbookDto;

import com.hjham.guestbook.domain.dto.PageRequestDto;
import com.hjham.guestbook.domain.dto.PageResultDto;
import com.hjham.guestbook.domain.entity.Guestbook;
import com.hjham.guestbook.domain.entity.QGuestbook;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;


public interface GuestbookService {
  Long write(GuestbookDto dto);
  PageResultDto<GuestbookDto, Guestbook> list(PageRequestDto dto);

  void modify(GuestbookDto dto);
  void remove(Long gno);

  // GuestbookViewDto get(Long gno);

  GuestbookDto read(Long gno);

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

  // private BooleanBuilder getSearch(PageRequestDto requestDto){
  //   String type = requestDto.getType();
  //   BooleanBuilder booleanBuilder = new BooleanBuilder();
  //   QGuestbook qGuestbook = QGuestbook.guestbook;
  //   BooleanExpression expression = qGuestbook.gno.gt(0L);
  //   booleanBuilder.and(expression);
  //   if(type == null || type.trim().isEmpty()){
  //     return booleanBuilder;
  //   }

  //   BooleanBuilder conditionalBuilder = new BooleanBuilder();
  //   String keyword = requestDto.getKeyword();
  //   if(type.contains("T")){
  //     conditionalBuilder.or(qGuestbook.title.contains(keyword));
  //   }
  //   if(type.contains("C")){
  //     conditionalBuilder.or(qGuestbook.content.contains(keyword));
  //   }
  //   if(type.contains("W")){
  //     conditionalBuilder.or(qGuestbook.writer.contains(keyword));
  //   }
  //   booleanBuilder.and(conditionalBuilder);
  //   return booleanBuilder;
  // }
  
}
