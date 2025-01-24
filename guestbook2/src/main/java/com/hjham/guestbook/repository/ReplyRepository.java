package com.hjham.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hjham.guestbook.domain.entity.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long>{
  void deleteByBoardBno(Long bno);
}
