package com.hjham.club.service;

import com.hjham.club.entity.Attach;
import com.hjham.club.entity.Member;
import com.hjham.club.entity.Note;
import com.hjham.club.entity.dto.AttachDto;
import com.hjham.club.entity.dto.NoteDto;

import java.util.List;
import java.util.Optional;

public interface NoteService {
  Long write(NoteDto noteDto);  
  Optional <NoteDto> get(Long num);  
  int modify(NoteDto noteDto);
  int remove(Long num);
  List<NoteDto> list(String writerEmail);
  List<NoteDto> listAll();

  default Note dtoToEntity(NoteDto noteDto) {
    Note note = Note.builder()
    .num(noteDto.getNum())
    .title(noteDto.getTitle())
    .content(noteDto.getContent())
    .member(Member.builder().email(noteDto.getMemberEmail()).mno(noteDto.getMno()).build())
    .build();

    note.setAttachs(noteDto.getAttachDtos().stream().map(a -> Attach.builder()
        .uuid(a.getUuid())
        .origin(a.getOrigin())
        .ext(a.getExt())
        .fileName(a.getFileName())
        .image(a.isImage())
        .mime(a.getMime())
        .path(a.getPath())
        .size(a.getSize())
        .url(a.getUrl())
        .note(note)
        .build()).toList()
      );
    return note;
  }

  default NoteDto entityToDto(Note note) {
    NoteDto noteDto = NoteDto.builder()
      .num(note.getNum())
      .title(note.getTitle())
      .content(note.getContent())
      .memberEmail(note.getMember().getEmail())
      .mno(note.getMember().getMno())
      .regDate(note.getRegDate())
      .modDate(note.getModDate())
      .attachDtos(note.getAttachs().stream().map(a -> AttachDto.builder()
        .ext(a.getExt())
        .fileName(a.getFileName())
        .image(a.isImage())
        .mime(a.getMime())
        .num(a.getNote().getNum())
        .origin(a.getOrigin())
        .path(a.getPath())
        .size(a.getSize())
        .url(a.getUrl())
        .uuid(a.getUuid())
        .build()).toList()
      ).build();

    return noteDto;
  }
}
