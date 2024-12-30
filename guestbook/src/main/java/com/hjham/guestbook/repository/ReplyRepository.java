package com.hjham.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hjham.guestbook.domain.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long>{
  
}
