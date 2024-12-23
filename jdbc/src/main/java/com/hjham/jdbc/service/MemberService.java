package com.hjham.jdbc.service;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hjham.jdbc.dao.MemberDao;
import com.hjham.jdbc.dao.PostDao;
import com.hjham.jdbc.dao.ReplyDao;

import jakarta.annotation.sql.DataSourceDefinition;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MemberService {
  private MemberDao memberDao;
  private PostDao postDao;
  private ReplyDao replyDao;

  // private DataSourceTransactionManager manager;
  // private DataSourceDefinition definition;

  // public void quitMember(String id) {
  //   TransactionStatus status = manager.getTransaction(definition);
   
  //   try {
  //     replyDao.updateWriterNull(id);
  //     postDao.updateWriterNull(id);
  //     memberDao.delete(id);
  //     manager.commit(status);
  //   }
  //   catch(DataAccessException e) {
  //     manager.rollback(status);

  //   }
  // }

  // @Transactional를 쓰면 위의 경우처럼 할 필요가 없다
  @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
  public void quitMember(String id) {
    replyDao.updateWriterNull(id);
    postDao.updateWriterNull(id);
    memberDao.delete(id);
  }
}
