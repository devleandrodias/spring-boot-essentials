package com.spring.awesome.endpoint;

import java.util.Optional;

import com.spring.awesome.error.CustomErrorType;
import com.spring.awesome.model.Student;
import com.spring.awesome.repository.StudentRepository;

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

  private final StudentRepository studentDAO;

  // Faz injeção da depência da classe DateUtil
  // Aconselhavel coloca-lo dentro de um construtor
  @Autowired
  public StudentEndpoint(StudentRepository studentDAO) {
    this.studentDAO = studentDAO;
  }

  // GET sem path retorna tudo
  // @RequestMapping(method = RequestMethod.GET)
  @GetMapping
  public ResponseEntity<?> listAll() {

    return new ResponseEntity<>(studentDAO.findAll(), HttpStatus.OK);
  }

  // GET GetById
  // @RequestMapping(method = RequestMethod.GET, path = "/{id}")
  @GetMapping(path = "/{id}") // Substitui o de cima
  public ResponseEntity<?> getStudentById(@PathVariable("id") Long id) {

    Optional<Student> student = studentDAO.findById(id);

    if (student == null)
      return new ResponseEntity<>(new CustomErrorType("Student not found"), HttpStatus.NOT_FOUND);

    return new ResponseEntity<>(student, HttpStatus.OK);
  }

  // POST - Incluir
  // @RequestMapping(method = RequestMethod.POST)
  @PostMapping // Substitui o de cima
  public ResponseEntity<?> save(@RequestBody Student student) {

    return new ResponseEntity<>(studentDAO.save(student), HttpStatus.CREATED);
  }

  // PUT - Atualizar
  // @RequestMapping(method = RequestMethod.PUT)
  @PutMapping // Substitui o de cima
  public ResponseEntity<?> update(@RequestBody Student student) {

    studentDAO.save(student); // Ele sabe que tem q ser atualizado, quando vem com ID
    return new ResponseEntity<>(student, HttpStatus.OK);
  }

  // DELETE - Deletar
  // Idempotent (Se você fizer várias vezes a mesma requisição mesmo resultado)
  // @RequestMapping(method = RequestMethod.DELETE)
  @DeleteMapping(path = "/{id}") // Subtitui o de cima
  public ResponseEntity<?> delete(@PathVariable("id") Long id) {

    studentDAO.deleteById(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping(path = "/findByName/{name}")
  public ResponseEntity<?> findByName(@PathVariable String name) {
    return new ResponseEntity<>(studentDAO.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
  }
}

/**
 * System.out.println("Data Local: " +
 * dateUtil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
 */