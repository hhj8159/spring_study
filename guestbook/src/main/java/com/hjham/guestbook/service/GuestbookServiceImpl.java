package com.hjham.guestbook.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.hjham.guestbook.domain.dto.GuestbookDto;
import com.hjham.guestbook.domain.dto.GuestbookListDto;
import com.hjham.guestbook.domain.dto.GuestbookModifyDto;
import com.hjham.guestbook.domain.dto.GuestbookViewDto;
import com.hjham.guestbook.domain.dto.PageRequestDto;
import com.hjham.guestbook.domain.dto.PageResultDto;
import com.hjham.guestbook.domain.entity.Guestbook;
import com.hjham.guestbook.repository.GuestbookRepository;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@AllArgsConstructor
public class GuestbookServiceImpl implements GuestbookService{
  private GuestbookRepository repository;

  @Override
  public GuestbookViewDto get(Long gno) {
    Optional<Guestbook> opt = repository.findById(gno);
    if (!opt.isPresent()) {
      return null;
    }    
    return new GuestbookViewDto(opt.get());
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
  public Long write(GuestbookDto dto) {
    Guestbook guestbook = toEntity(dto);
    log.info(guestbook);
    repository.save(guestbook);
    log.info(guestbook);
    return guestbook.getGno();
  }

  @Override
  public PageResultDto<GuestbookDto, Guestbook> list(PageRequestDto dto) {
    Pageable pageable = dto.getPageable(Sort.by(Direction.DESC, "gno"));
    Page<Guestbook> page = repository.findAll(pageable);
    PageResultDto<GuestbookDto, Guestbook> resultDto = new PageResultDto<>(page, e -> toDto(e));
    return resultDto;
  }
  
  
}
