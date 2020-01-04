package com.spring.awesome.endpoint;

import java.util.List;

import com.spring.awesome.model.Student;
import com.spring.awesome.util.DateUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Arrays.asList;

import java.time.LocalDateTime;

/**
 * StudentEndpoint
 */
@RestController // Aqui é nosso endpoint
@RequestMapping("student") // onde ele vai acessar (Rota)
public class StudentEndpoint {

  // Faz injeção da depência da classe DateUtil
  @Autowired
  private DateUtil dateUtil;

  @RequestMapping(method = RequestMethod.GET, path = "/list")
  public List<Student> listAll() {

    System.out.println("Data Local: " + dateUtil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));

    return asList(new Student("Leandro"), new Student("Thaísa"));
  }
}