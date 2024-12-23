package com.hjham.member_post2.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class CommonController {
  @GetMapping({"/", "/index"})
  public String index() {
    log.info("index controller");
    return "common/index";
  }

  // 테스트
  // @GetMapping("map")
  // @ResponseBody
  // public Map<?,?> getmethodName() {
  //   Map<String, Object> map = new HashMap<>();
  //   map.put("A", 1) ;
  //   return map;
  // }

}
