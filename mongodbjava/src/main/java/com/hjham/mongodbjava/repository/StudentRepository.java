package com.hjham.mongodbjava.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hjham.mongodbjava.entity.Student;

public interface StudentRepository extends MongoRepository<Student, Long>{
  
}
