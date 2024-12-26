package com.hjham.guestbook.controller;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hjham.guestbook.domain.dto.PageRequestDto;
import com.hjham.guestbook.service.GuestbookService;

import lombok.extern.log4j.Log4j2;


@Controller
@RequestMapping("guestbook")
@Log4j2
public class GuestbookController {
  // @Autowired
  @Inject
  private GuestbookService service;

  @GetMapping({"", "/", "list"})
  public String list(Model model, PageRequestDto dto) {
    log.info("list");
    model.addAttribute("result", service.list(dto));
    return "/guestbook/list";
  }
  
}
