package com.hjham.club.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "tbl_note")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "member")
public class Note extends BaseEntity{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long num;
  private String title;
  private String content;
  // @ManyToOne(fetch = FetchType.LAZY)
  @ManyToOne
  private Member member;

  //
  public void changeTitle(String title) {
    this.title = title;
  }
  public void changeContent(String content) {
    this.content = content;
  }
}
