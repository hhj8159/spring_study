package com.hjham.guestbook.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hjham.guestbook.domain.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{
  @Query("select b,m from tbl_board b left join member m where b.bno = :bno")
  Object getBoardWithMember(@Param("bno") Long bno);

  @Query("select b,r from tbl_board b left join tbl_reply r on b = r.board where bno = :bno")
  List<Object[]> getBoardWithReply(@Param("bno") Long bno);

  @Query(value = "select count(r), b, m\r\n" + //
        "from tbl_board b\r\n" + //
        "left join member m\r\n" + //
        "left join tbl_reply r on b = r.board\r\n" + //
        "group by b"
  , countQuery = "select count(b) from tbl_board b") // jpa는 데이터베이스 안가림 nativeQuery = true 는 최후의 수단
  Page<Object[]> getBoardWithReplyCount(Pageable pageable);

  // bno, 회원, 게시글, 댓글갯수
  @Query(value = "select count(r), b, m\r\n" + //
        "from tbl_board b\r\n" + //
        "left join member m\r\n" + //
        "left join tbl_reply r on b = r.board\r\n" + //
        "where b.bno = :bno \r\n" //
        )
  Object getBoardByBno(@Param("bno") Long bno);



}
