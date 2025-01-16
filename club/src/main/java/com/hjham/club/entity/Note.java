package com.hjham.club.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.Builder.Default;

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

  @Default
  @Setter
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "note", orphanRemoval = true, cascade = CascadeType.ALL)
  private List<Attach> attachs = new ArrayList<>();







  //
  public void changeTitle(String title) {
    this.title = title;
  }
  public void changeContent(String content) {
    this.content = content;
  }
}
