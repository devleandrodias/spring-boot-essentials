package com.spring.awesome.endpoint;

import com.spring.awesome.error.CustomErrorType;
import com.spring.awesome.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
  // @RequestMapping(method = RequestMethod.GET)
  @GetMapping
  public ResponseEntity<?> listAll() {

    return new ResponseEntity<>(Student.studentList, HttpStatus.OK);
  }

  // GET GetById
  // @RequestMapping(method = RequestMethod.GET, path = "/{id}")
  @GetMapping(path = "/{id}") // Substitui o de cima
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

  // POST - Incluir
  // @RequestMapping(method = RequestMethod.POST)
  @PostMapping // Substitui o de cima
  public ResponseEntity<?> save(@RequestBody Student student) {

    Student.studentList.add(student);

    return new ResponseEntity<>(student, HttpStatus.OK);
  }

  // PUT - Atualizar
  // @RequestMapping(method = RequestMethod.PUT)
  @PutMapping // Substitui o de cima
  public ResponseEntity<?> update(@RequestBody Student student) {

    Student.studentList.remove(student);
    Student.studentList.add(student);

    return new ResponseEntity<>(student, HttpStatus.OK);
  }

  // DELETE - Deletar
  // Idempotent (Se você fizer várias vezes a mesma requisição mesmo resultado)
  // @RequestMapping(method = RequestMethod.DELETE)
  @DeleteMapping // Subtitui o de cima
  public ResponseEntity<?> delete(@RequestBody Student student) {

    Student.studentList.remove(student);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}

/**
 * System.out.println("Data Local: " +
 * dateUtil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
 */