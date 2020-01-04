package com.spring.awesome.endpoint;

import com.spring.awesome.error.CustomErrorType;
import com.spring.awesome.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * StudentEndpoint
 */
@RestController // Aqui é nosso endpoint
// Usar mapping no plutal
@RequestMapping("students") // onde ele vai acessar (Rota)
public class StudentEndpoint {

  // Faz injeção da depência da classe DateUtil
  // Aconselhavel coloca-lo dentro de um construtor
  @Autowired
  public StudentEndpoint() {

  }

  // GET sem path retorna tudo
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<?> listAll() {

    return new ResponseEntity<>(Student.studentList, HttpStatus.OK);
  }

  // GET GetById
  @RequestMapping(method = RequestMethod.GET, path = "/{id}")
  public ResponseEntity<?> getStudentById(@PathVariable("id") int id) {

    Student student = new Student();

    student.setId(id);

    int index = Student.studentList.indexOf(student);

    // Caso não encontre

    if (index == -1)
      return new ResponseEntity<>(new CustomErrorType("Student not found"), HttpStatus.NOT_FOUND);
    else
      return new ResponseEntity<>(Student.studentList.get(index), HttpStatus.OK);
  }
}

/**
 * System.out.println("Data Local: " +
 * dateUtil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
 */