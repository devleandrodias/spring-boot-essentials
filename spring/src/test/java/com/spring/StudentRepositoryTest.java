package com.spring;

import com.spring.awesome.model.Student;
import com.spring.awesome.repository.StudentRepository;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * StudentRepositoryTest
 */
// Necessário para rodar os testes
@RunWith(SpringRunner.class)
// Ajuda na criação dos nossos testes
@DataJpaTest
public class StudentRepositoryTest {

  @Autowired
  private StudentRepository studentRepository;

  @Test
  public void createShouldPersistData() {
    Student student = new Student("Leandro Dias", "devleandro@gmail.com");
    this.studentRepository.save(student);
    Assertions.assertThat(student.getId()).isNotNull();
    Assertions.assertThat(student.getName()).isEqualTo("Leandro Dias");
    Assertions.assertThat(student.getEmail()).isEqualTo("devleandro@gmail.com");

  }
}