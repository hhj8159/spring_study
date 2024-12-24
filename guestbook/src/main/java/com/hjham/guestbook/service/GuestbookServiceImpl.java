package com.hjham.guestbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hjham.guestbook.domain.entity.GuestbookEntity;
import com.hjham.guestbook.dto.GuestbookListDto;
import com.hjham.guestbook.dto.GuestbookModifyDto;
import com.hjham.guestbook.dto.GuestbookViewDto;
import com.hjham.guestbook.dto.GuestbookWriteDto;
import com.hjham.guestbook.repository.GuestbookRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GuestbookServiceImpl implements GuestbookService{
  private GuestbookRepository repository;

  @Override
  public GuestbookViewDto get(Long gno) {
    Optional<GuestbookEntity> opt = repository.findById(gno);
    if (!opt.isPresent()) {
      return null;
    }    
    return new GuestbookViewDto(opt.get());
  }

  @Override
  public List<GuestbookListDto> list() {
    return repository.findAll().stream().map(GuestbookListDto::new).toList();
  }

  @Override
  public void modify(GuestbookModifyDto dto) {
    repository.save(dto.toEntity());
  }
  
  @Override
  public void remove(Long gno) {
    repository.deleteById(gno);
  }
  
  @Override
  public void writer(GuestbookWriteDto dto) {
    repository.save(dto.toEntity());
  }
  
}
