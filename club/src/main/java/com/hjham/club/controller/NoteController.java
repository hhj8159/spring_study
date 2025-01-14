package com.hjham.club.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hjham.club.entity.dto.NoteDto;
import com.hjham.club.service.NoteService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    log.info(email);
    return service.list(email);
  }
  
  @GetMapping("listAll")
  public List<NoteDto> listAll() {
      return service.listAll();
  }
  

  @SuppressWarnings("unchecked")
  @GetMapping("{num}")
  public ResponseEntity<?> get(@PathVariable Long num) {
    return service.get(num).map(ResponseEntity::ok)
      .orElseGet(() -> {
        Map<String, Object> ret = new HashMap<>();
        ret.put("code", 404);
        ret.put("message", "NOT_FOUND");
        ResponseEntity<?> entity = new ResponseEntity<>(ret, HttpStatus.NOT_FOUND);
        return (ResponseEntity<NoteDto>) entity;
      });
      // 전역 예외처리 @RestControllerAdivce ex)404 message같은 것
  }
  
  @PutMapping("{num}")
  public String modify(@PathVariable Long num, @RequestBody NoteDto dto) {
    return service.modify(dto) > 0 ? "success" : "failure" ;
  }
  
  @DeleteMapping("{num}")
  public String remove(@PathVariable Long num) {
    return service.remove(num) > 0 ? "success" : "failure" ;
  }
}
