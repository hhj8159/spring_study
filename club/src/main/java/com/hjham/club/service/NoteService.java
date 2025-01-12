package com.hjham.club.service;

import com.hjham.club.entity.Member;
import com.hjham.club.entity.Note;
import com.hjham.club.entity.dto.NoteDto;

import java.util.List;

public interface NoteService {
  Long write(NoteDto noteDto);  
  NoteDto get(Long num);  
//  void modify(NoteDto noteDto);
  int modify(NoteDto noteDto);
//  void remove(Long num);
  int remove(Long num);
  List<NoteDto> list(String writerEmail);

  default Note dtoToEntity(NoteDto noteDto) {
    Note note = Note.builder()
      .num(noteDto.getNum())
      .title(noteDto.getTitle())
      .content(noteDto.getContent())
      .member(Member.builder().email(noteDto.getWriterEmail()).mno(noteDto.getMno()).build())
      .build();
    return note;
  }

  default NoteDto entityToDto(Note note) {
    NoteDto noteDto = NoteDto.builder()
      .num(note.getNum())
      .title(note.getTitle())
      .content(note.getContent())
      .writerEmail(note.getMember().getEmail())
      .mno(note.getMember().getMno())
      .regDate(note.getRegDate())
      .modDate(note.getModDate())
      .build();

    return noteDto;
  }
}
