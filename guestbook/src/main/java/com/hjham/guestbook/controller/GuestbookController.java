package com.hjham.guestbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j2;


@Controller
@RequestMapping("guestbook")
@Log4j2
public class GuestbookController {
  @GetMapping({"", "/", "list"})
  public String list() {
    log.info("list");
    return "/guestbook/list";
  }
  
}
