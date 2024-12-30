package com.hjham.guestbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hjham.guestbook.domain.dto.BoardDto;
import com.hjham.guestbook.domain.entity.Board;
import com.hjham.guestbook.repository.BoardRepository;

import lombok.Data;

@Service
@Data
public class BoardServiceImpl implements BoardService{
  @Autowired
  private BoardRepository repository;

  @Override
  public BoardDto get(Long bno) {
    return toDto(repository.getBoardByBno(bno));
  }

  @Override
  public Long register(BoardDto dto) {
    Board board = toEntity(dto);
    repository.save(board);
    return board.getBno();
  }
  
}
