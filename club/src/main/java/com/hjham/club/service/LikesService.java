package com.hjham.club.service;

import com.hjham.club.entity.Likes;
import com.hjham.club.entity.Member;
import com.hjham.club.entity.Note;
import com.hjham.club.entity.dto.LikesDto;

public interface LikesService {
  boolean toggle(LikesDto dto);
  boolean get(LikesDto dto);

  default Likes dtoToEntity(LikesDto dto) {
    return Likes.builder()
      .member(Member.builder().mno(dto.getMno()).build())
      .note(Note.builder().num(dto.getNum()).build())
    .build();
  }
  default LikesDto entityToDto(Likes likes) {
    return LikesDto.builder()
      .email(likes.getMember().getEmail())
      .mno(likes.getMember().getMno())
      .modDate(likes.getModDate())
      .regDate(likes.getRegDate())
      .num(likes.getNote().getNum())
    .build();

  }
} 
