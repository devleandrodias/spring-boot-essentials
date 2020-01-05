package com.spring.awesome.endpoint;

import java.util.Optional;

import javax.validation.Valid;

import com.spring.awesome.error.ResourceNotFoundException;
import com.spring.awesome.model.Student;
import com.spring.awesome.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
@RequestMapping("v1") // onde ele vai acessar (Rota)
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
  @GetMapping(path = "protected/students")
  public ResponseEntity<?> listAll(/* Pageable pageable */ /** Paginação */
  ) {

    // sort=id,desc ou asc
    return new ResponseEntity<>(studentDAO.findAll(/* pageable */), HttpStatus.OK);
  }

  // GET GetById
  // @RequestMapping(method = RequestMethod.GET, path = "/{id}")
  @GetMapping(path = "protected/students/{id}") // Substitui o de cima
  public ResponseEntity<?> getStudentById(@PathVariable("id") Long id) {

    // Agora essa verficação está em um método verifyIfStudentsExists()
    Optional<Student> student = studentDAO.findById(id);

    // return new ResponseEntity<>(new CustomErrorType("Student not found"),
    // HttpStatus.NOT_FOUND);

    if (student.isPresent())
      return new ResponseEntity<>(student, HttpStatus.OK);
    else
      throw new ResourceNotFoundException("Student not found for ID: " + id);
  }

  // POST - Incluir
  // @RequestMapping(method = RequestMethod.POST)
  @PostMapping("admin/students") // Substitui o de cima
  /**
   * Por padrão trata execções do time uncheked, se quiser tratar exeções do tipo
   * uncheked usar roolbackFor = (Execção)
   */
  @Transactional // Fala que este método tem que estar em transação, lembrar InnoDB
  public ResponseEntity<?> save(@Valid @RequestBody Student student) {
    // @valid faz com que as validações sejam aplicadas ex @NotEmpty
    studentDAO.save(student); // Aqui ele cria
    // studentDAO.save(student); // Aqui ele atualiza por que tem o id

    // Caso der execção não pode persistir os de cima nem os de baixo
    // if (true)
    // throw new RuntimeException("Teste Transaction");
    // else
    return new ResponseEntity<>(studentDAO.save(student), HttpStatus.CREATED);
  }

  // PUT - Atualizar
  // @RequestMapping(method = RequestMethod.PUT)
  @PutMapping("admin/students") // Substitui o de cima
  public ResponseEntity<?> update(@RequestBody Student student) {

    verifyIfStudentsExists(student.getId());
    studentDAO.save(student); // Ele sabe que tem q ser atualizado, quando vem com ID
    return new ResponseEntity<>(student, HttpStatus.OK);
  }

  // DELETE - Deletar
  // Idempotent (Se você fizer várias vezes a mesma requisição mesmo resultado)
  // @RequestMapping(method = RequestMethod.DELETE)
  @DeleteMapping(path = "admin/students/{id}") // Subtitui o de cima
  // @PreAuthorize("hasRole('ADMIN')") Não mais necessário
  public ResponseEntity<?> delete(@PathVariable("id") Long id) {

    verifyIfStudentsExists(id);

    studentDAO.deleteById(id);

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping(path = "protected/students/findByName/{name}")
  public ResponseEntity<?> findByName(@PathVariable String name) {
    return new ResponseEntity<>(studentDAO.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
  }

  private void verifyIfStudentsExists(Long id) {
    Optional<Student> student = studentDAO.findById(id);

    if (!student.isPresent())
      throw new ResourceNotFoundException("Student not found for ID: " + id);
  }
}

/**
 * System.out.println("Data Local: " +
 * dateUtil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
 */