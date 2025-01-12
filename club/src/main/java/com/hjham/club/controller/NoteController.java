package com.hjham.club.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hjham.club.entity.dto.NoteDto;
import com.hjham.club.service.NoteService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notes/")
public class NoteController {
  private final NoteService service;

  @PostMapping
  public Long wirte(@RequestBody NoteDto dto) {
    return service.write(dto);
  }

  @GetMapping("list")
  public List<NoteDto> list(String email) {
      return service.list(email);
  }
  
  @GetMapping("{num}")
  public NoteDto get(@PathVariable Long num) {
      return service.get(num);
  }
  
  @PutMapping("{num}")
  public int modify(@PathVariable Long num, @RequestBody NoteDto dto) {
     return service.modify(dto);
  }
  
  @DeleteMapping("{num}")
  public int remove(@PathVariable Long num) {
     return service.remove(num);
  }
}