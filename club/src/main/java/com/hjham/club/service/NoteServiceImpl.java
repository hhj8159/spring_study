package com.hjham.club.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.hjham.club.entity.Likes;
import com.hjham.club.entity.Member;
import com.hjham.club.entity.Note;
import com.hjham.club.entity.dto.NoteDto;
import com.hjham.club.repository.LikesRepository;
import com.hjham.club.repository.MemberRepository;
import com.hjham.club.repository.NoteRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
  // @Autowired
  // private NoteRepository repository;
  @Autowired
  private final NoteRepository repository;
  @Autowired
  private MemberRepository memberRepository;
  @Autowired
  private LikesRepository likesRepository;

  @Override
  public Optional<NoteDto> get(Long num) { // null값도 있을수있기에 optional
    long count = likesRepository.count(Example.of(Likes.builder().note(Note.builder().num(num).build()).build()));
    log.info(count);
    return repository.findById(num).map(this::entityToDto).map(d -> { d.setLikesCnt(count); return d;});
  }

  @Override
  public List<NoteDto> list(String writerEmail) {
    return repository.findNotesBy(writerEmail).stream().map(o -> {
      NoteDto dto = entityToDto((Note)o[0]);
      dto.setLikesCnt((Long)o[1]);
      dto.setAttachCnt((Long)o[2]);
      return dto;
    }).toList();
  }
  
  @Override
  public Long write(NoteDto noteDto) {
    Member member = memberRepository.findByEmail(noteDto.getMemberEmail());
    noteDto.setMno(member.getMno());
    log.info(noteDto);
    return repository.save(dtoToEntity(noteDto)).getNum();

  }
  
  @Override
  public int modify(NoteDto noteDto) {
    repository.save(dtoToEntity(noteDto));
    return 1;    
  }

  @Override
  public int remove(Long num) {
    repository.deleteById(num);
    return 1;
  }

  @Override
  public List<NoteDto> listAll() {
    return repository.findNotes().stream().map(o -> {
      NoteDto dto = entityToDto((Note)o[0]);
      dto.setLikesCnt((Long)o[1]);
      dto.setAttachCnt((Long)o[2]);
      return dto;
    }).toList();
    // return repository.findAll().stream().map(this::entityToDto).toList();
  }

}
