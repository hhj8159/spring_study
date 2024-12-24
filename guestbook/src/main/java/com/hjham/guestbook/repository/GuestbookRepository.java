package com.hjham.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.hjham.guestbook.domain.entity.GuestbookEntity;

public interface GuestbookRepository extends JpaRepository<GuestbookEntity, Long>
// , QuerydslPredicateExecutor<GuestbookEntity> 
{
  
}
