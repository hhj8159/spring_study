package com.hjham.club.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hjham.club.security.dto.AuthMemberDto;




@Controller
@Log4j2
@RequestMapping("sample")
public class SampleController {
  @GetMapping("path")
  public String getMethodName() {
      return "/sample/all";
  }
  

  @GetMapping("all")
  public void exAll(@AuthenticationPrincipal AuthMemberDto dto) {
    log.info(dto);
    log.info("ex all");
  }
  @GetMapping("member")
  public void exMember(@AuthenticationPrincipal AuthMemberDto dto) {
    log.info(dto);
    log.info("ex member");
  }
  @GetMapping("admin")
  @PreAuthorize("hasRole('ADMIN')")//인가여부
  public void exAdmin(@AuthenticationPrincipal AuthMemberDto dto) {
    log.info(dto);
    log.info("ex admin");
  }

  @GetMapping("api")
  @PreAuthorize("isAuthenticated()")
  // @PreAuthorize("isAnonymous()")
  @ResponseBody
  public AuthMemberDto getMethodName(@AuthenticationPrincipal AuthMemberDto dto) {
      return dto;
  }
  
  @GetMapping("exMemberOnly")
  @ResponseBody
  @PreAuthorize("#dto != null && #dto.username eq \"user100@hjham.com\"")
  public String exMemberOnly(@AuthenticationPrincipal AuthMemberDto dto) {
    log.info(dto.getUsername());
    return dto.getEmail();
  }
  
  
}
