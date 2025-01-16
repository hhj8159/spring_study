package com.hjham.club.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hjham.club.entity.Likes;
import com.hjham.club.entity.composite.LikesId;


public interface LikesRepository extends JpaRepository<Likes, LikesId>{
  
}
