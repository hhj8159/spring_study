package com.hjham.club.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hjham.club.entity.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
  Note findByNum(Long num);
  
  List<Note> findByMemberMno(Long mno);

  List<Note> findByMemberEmail(String email);

  //
  // @EntityGraph(attributePaths = "writer", type = EntityGraph.EntityGraphType.LOAD)
  // @Query("select n from Note n where n.num = :num")
  // Optional<Note> getWithWriter(Long num);

  // @EntityGraph(attributePaths = {"writer"}, type = EntityGraph.EntityGraphType.LOAD)
  // @Query("select n from Note n where n.writer.email = :email")
  // List<Note> getList(String email);
}