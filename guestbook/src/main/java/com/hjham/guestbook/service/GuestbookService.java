package com.hjham.guestbook.service;

import java.util.List;

import com.hjham.guestbook.dto.GuestbookListDto;
import com.hjham.guestbook.dto.GuestbookModifyDto;
import com.hjham.guestbook.dto.GuestbookViewDto;
import com.hjham.guestbook.dto.GuestbookWriteDto;

public interface GuestbookService {
  void writer(GuestbookWriteDto dto);
  void modify(GuestbookModifyDto dto);
  void remove(Long gno);

  List<GuestbookListDto> list();
  GuestbookViewDto get(Long gno);
  
}
