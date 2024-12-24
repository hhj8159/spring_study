package com.hjham.guestbook.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "tbl_guestbook")
public class GuestbookEntity extends BaseEntity{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long gno;

  // 원래 final로 하는게 맞음
  @Column(nullable = false, length = 100)
  private String title;
  @Column(nullable = false, length = 1500)
  private String content;
  @Column(nullable = false, length = 50)
  private String writer;
}
