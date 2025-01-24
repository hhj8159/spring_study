package com.hjham.mongodbjava.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hjham.mongodbjava.entity.Student;
import com.hjham.mongodbjava.service.StudentService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@AllArgsConstructor
@RequestMapping
public class StudentController {
  private StudentService studentService;

  @PostMapping("register")
  public void register(@RequestBody Student student) {
    studentService.register(student);
  }

  @GetMapping("students")
  public List<Student> list() {
      return studentService.list();
  }

  @GetMapping("students/{no}")
  public Student get(@PathVariable Long no) {
      return studentService.get(no).orElse(null);
  }
  
}
