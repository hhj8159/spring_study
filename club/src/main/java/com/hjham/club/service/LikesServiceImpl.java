package com.hjham.club.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hjham.club.entity.composite.LikesId;
import com.hjham.club.entity.dto.LikesDto;
import com.hjham.club.repository.LikesRepository;
import com.hjham.club.repository.MemberRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class LikesServiceImpl implements LikesService{
  @Autowired
  private LikesRepository repository;
  @Autowired
  private MemberRepository memberRepository;

  @Override
  public boolean get(LikesDto dto) {    
    if(dto.getMno() == null) {
      Long mno = memberRepository.findByEmail(dto.getEmail()).getMno();
      dto.setMno(mno);
    }
    return repository.findById(new LikesId(dto)).isPresent();
  }

  @Override
  public boolean toggle(LikesDto dto) {
    if(dto.getMno() == null) {
      Long mno = memberRepository.findByEmail(dto.getEmail()).getMno();
      dto.setMno(mno);
    }
    
    boolean ret = get(dto);
    if(ret) {
      repository.delete(dtoToEntity(dto));
    }
    else {  
      repository.save(dtoToEntity(dto));
    }  
    return ret;
  }
  
}
