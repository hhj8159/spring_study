package com.hjham.club.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hjham.club.entity.Member;
import com.hjham.club.entity.Note;
import com.hjham.club.entity.dto.LikesDto;
import com.hjham.club.repository.MemberRepository;
import com.hjham.club.repository.NoteRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class LikesServiceTests {
  @Autowired
  private LikesService service;
  @Autowired
  private MemberRepository memberRepository;
  @Autowired
  private NoteRepository noteRepository;
  
  LikesDto likesDto = LikesDto.builder()
    .mno(100L)
    .num(1L)
    .build();

  @Test
  public void testGet() {
    log.info(service.get(likesDto)); 
  }

  @Test
  public void testToggle() {
    service.toggle(likesDto);
  }

  @Test
  public void testInsertDummy() {
    List<Long> mnos = new ArrayList<>(memberRepository.findAll().stream().map(Member::getMno).toList());
    List<Long> nums = new ArrayList<>(noteRepository.findAll().stream().map(Note::getNum).toList());

    Collections.shuffle(mnos);
    Collections.shuffle(nums);

    // mnos.subList(0, (int) (mnos.size() * .2));

    List<LikesDto> likesDtos = new ArrayList<>();
    for(int i = 0; i < mnos.size(); i++) {
      for(int j = 0; j < nums.size(); j++) {
        likesDtos.add(LikesDto.builder().mno(mnos.get(i)).num(nums.get(j)).build());
      }
    }
    log.info(likesDtos.size());

    likesDtos = likesDtos.subList(0, likesDtos.size() / 5);

    log.info(likesDtos.size());

    likesDtos.forEach(dto -> service.toggle(dto));
  }
}
