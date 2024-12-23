package com.hjham.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hjham.demo.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class MemberService {
    @Autowired
    private MemberMapper mapper;

    public String selectNow() {
        log.error(mapper.selectNow());
        return mapper.selectNow();
    }
}
