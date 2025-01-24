package com.hjham.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hjham.guestbook.domain.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String>{
  
}
