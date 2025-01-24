package com.hjham.guestbook.repository;

import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.hjham.guestbook.domain.entity.Guestbook;
import com.hjham.guestbook.domain.entity.QGuestbook;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

import jakarta.transaction.Transactional;
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
  @Transactional
  public void testInsert() {
    repository.saveAll(
      IntStream.rangeClosed(1, 300).mapToObj(i->{
        return Guestbook.builder()
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
    Optional<Guestbook> opt = repository.findById(gno);
    // GuestbookEntity modifiedEntity = null;
    opt.ifPresent(entity -> {
      Guestbook modifiedEntity = Guestbook.builder()
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

  @Test
  public void testQuerydsl() {
    Guestbook.GuestbookBuilder builder1 = Guestbook.builder();
    builder1.content("콘텐트");
    builder1.title("타이틀");
    Guestbook entity = builder1.build();

    Pageable pageable = PageRequest.of(0, 10, Sort.by(Direction.DESC, "gno"));

    // 객체 취득
    QGuestbook qGuestbookEntity = QGuestbook.guestbook;

    String keyword = "1";

    // where평가 빌더 (조건절 들어가는 빌더 컨테이너)
    BooleanBuilder builder = new BooleanBuilder();

    // expression 
    BooleanExpression expression = qGuestbookEntity.title.contains(keyword);

    // where and or
    builder.and(expression);
    builder.or(qGuestbookEntity.writer.contains(keyword));

    Page<Guestbook> result = repository.findAll(builder, pageable);
    result.forEach(log::info);
  }

  
  
 
}
