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

import com.hjham.guestbook.domain.dto.PageRequestDto;
import com.hjham.guestbook.domain.dto.PageResultDto;
import com.hjham.guestbook.domain.entity.Guestbook;
import com.hjham.guestbook.domain.entity.QGuestbook;
import com.hjham.guestbook.repository.GuestbookRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@AllArgsConstructor
public class GuestbookServiceImpl implements GuestbookService{
  private GuestbookRepository repository;

  @Override
  public GuestbookDto read(Long gno) {
    Optional<Guestbook> opt = repository.findById(gno);
    return opt.isPresent() ? toDto(opt.get()) : null;
  }

  // @Override
  // public GuestbookViewDto get(Long gno) {
  //   Optional<Guestbook> opt = repository.findById(gno);
  //   if (!opt.isPresent()) {
  //     return null;
  //   }    
  //   return new GuestbookViewDto(opt.get());
  // }

  @Override
  public void modify(GuestbookDto dto) {
    repository.save(toEntity(dto));
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
    BooleanBuilder booleanBuilder = getSearch(dto);
    Page<Guestbook> page = repository.findAll(booleanBuilder, pageable);
    PageResultDto<GuestbookDto, Guestbook> resultDto = new PageResultDto<>(page, e -> toDto(e));
    return resultDto;
  }
  



  private BooleanBuilder getSearch(PageRequestDto requestDto){
  String type = requestDto.getType();
  BooleanBuilder booleanBuilder = new BooleanBuilder();
  QGuestbook qGuestbook = QGuestbook.guestbook;
  BooleanExpression expression = qGuestbook.gno.gt(0L);
  booleanBuilder.and(expression);
  if(type == null || type.trim().isEmpty()){
    return booleanBuilder;
  }

  BooleanBuilder conditionalBuilder = new BooleanBuilder();
  String keyword = requestDto.getKeyword();
  if(type.contains("T")){
    conditionalBuilder.or(qGuestbook.title.contains(keyword));
  }
  if(type.contains("C")){
    conditionalBuilder.or(qGuestbook.content.contains(keyword));
  }
  if(type.contains("W")){
    conditionalBuilder.or(qGuestbook.writer.contains(keyword));
  }
  booleanBuilder.and(conditionalBuilder);
  return booleanBuilder;
}

}
