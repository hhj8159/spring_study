package com.hjham.guestbook.service;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.hjham.guestbook.domain.dto.BoardDto;
import com.hjham.guestbook.domain.dto.GuestbookDto;
import com.hjham.guestbook.domain.dto.PageRequestDto;
import com.hjham.guestbook.domain.dto.PageResultDto;
import com.hjham.guestbook.domain.entity.Board;
import com.hjham.guestbook.domain.entity.Guestbook;
import com.hjham.guestbook.repository.BoardRepository;
import com.hjham.guestbook.repository.ReplyRepository;
import com.querydsl.core.BooleanBuilder;

import jakarta.transaction.Transactional;
import lombok.Data;

@Service
@Data
public class BoardServiceImpl implements BoardService{
  @Autowired
  private BoardRepository repository;
  @Autowired
  private ReplyRepository replyRepository;

  @Override
  public BoardDto get(Long bno) {
    return toDto((Object[])repository.getBoardByBno(bno));
  }

  @Override
  public Long register(BoardDto dto) {
    Board board = toEntity(dto);
    repository.save(board);
    return board.getBno();
  }

  @Override
  public PageResultDto<BoardDto, Object[]> list(PageRequestDto dto) {
    Pageable pageable = dto.getPageable(Sort.by(Direction.DESC, "bno"));
    // BooleanBuilder booleanBuilder = getSearch(dto);

    Page<Object[]> page = repository.searchPage(dto.getType(), dto.getKeyword(), pageable);
    Function<Object[], BoardDto> fn = e -> toDto(e);
    PageResultDto<BoardDto, Object[]> resultDto = new PageResultDto<>(page, fn);
    return resultDto;
  }

  @Override
  public void modify(BoardDto dto) {
    repository.save(toEntity(dto));
  }

  @Override
  @Transactional
  public void remove(Long bno) {
    replyRepository.deleteByBoardBno(bno);
    repository.deleteById(bno);
  }

  
  
}
