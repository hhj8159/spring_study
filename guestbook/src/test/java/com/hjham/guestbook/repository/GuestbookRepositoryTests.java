package com.hjham.guestbook.repository;

import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hjham.guestbook.domain.entity.GuestbookEntity;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class GuestbookRepositoryTests {
  @Autowired
  private GuestbookRepository repository;

  @Test
  public void testExist() {
    log.info(repository);
  }

  @Test
  public void testInsert() {
    repository.saveAll(
      IntStream.rangeClosed(1, 300).mapToObj(i->{
        return GuestbookEntity.builder()
        .title("제목"+i)
        .content("내용"+i)
        .writer("작성자" + (i % 10))
        .build();
      }).toList()
    );
  }

  @Test
  public void testSelectList() {
    repository.findAll().forEach(log::info);
  }

  @Test
  public void testSelectOne() {
    log.info(repository.findById(1L));
  }

  @Test
  public void testModify() {
    Long gno = 1L;
    Optional<GuestbookEntity> opt = repository.findById(gno);
    // GuestbookEntity modifiedEntity = null;
    opt.ifPresent(entity -> {
      GuestbookEntity modifiedEntity = GuestbookEntity.builder()
      .gno(entity.getGno())
      .title(entity.getTitle())
      .content("변경된 내용")
      .writer(entity.getWriter())
      .build();
      repository.save(modifiedEntity);
    });
    
    // if(!opt.isPresent()){
      //   return;
      // }
    // GuestbookEntity modifiedEntity = GuestbookEntity.builder()
    // .gno(entity.getGno())
    // .title(entity.getTitle())
    // .content("변경된 내용")
    // .writer(entity.getWriter())
    // .build();
    // repository.save(modifiedEntity);

    // repository.save(modifiedEntity);
    // repository.save(GuestbookEntity.builder()
    // .gno(gno)
    // .title("수정제목")
    // .content("수정내용")
    // .writer("작성자2")
    // .build());
  }
}
