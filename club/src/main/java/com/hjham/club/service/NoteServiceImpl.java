package com.hjham.club.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hjham.club.entity.Note;
import com.hjham.club.entity.dto.NoteDto;
import com.hjham.club.repository.NoteRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
  
  private final NoteRepository repository;

  @Override
  public NoteDto get(Long num) {
    return entityToDto(repository.findByNum(num));
    // Optional<Note> result = noteRepository.findById(num);
    // log.info("getstart");
    // if(result.isPresent()) {      
    //   log.info(result.get());
    //   return entityToDto(result.get());
    // }
    // return null;
  }

  @Override
  public List<NoteDto> list(String writerEmail) {
    List<Note> noteList = repository.findByMemberEmail(writerEmail);
    return noteList.stream().map(note -> entityToDto(note)).collect(Collectors.toList());
  }

  @Override
  public void modify(NoteDto noteDto) {
    Long num = noteDto.getNum();
    Optional<Note> result = repository.findById(num);
    if(result.isPresent()) {
      Note note = result.get();
      note.changeTitle(noteDto.getTitle());
      note.changeContent(noteDto.getContent());
      repository.save(note);
    }    
  }

  @Override
  public Long write(NoteDto noteDto) {
    Note note = dtoToEntity(noteDto);

    log.info("====================");
    log.info(note);

    repository.save(note);
    return note.getNum();
  }

  @Override
  public void remove(Long num) {
    repository.deleteById(num);
  }

  


  
}
