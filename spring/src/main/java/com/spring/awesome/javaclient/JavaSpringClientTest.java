package com.spring.awesome.javaclient;

import java.util.Arrays;
import java.util.List;

import com.spring.awesome.model.Student;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * JavaSpringClientTest
 */
public class JavaSpringClientTest {

  public static void main(String[] args) {
    RestTemplate restTemplate = new RestTemplateBuilder().rootUri("http://localhost:8080/v1/protected/students")
        .basicAuthentication("devleandrodias", "devleandro").build();

    Student student = restTemplate.getForObject("/{id}", Student.class, 5);
    ResponseEntity<Student> entity = restTemplate.getForEntity("/{id}", Student.class, 5);

    System.out.println(student);
    System.out.println("---------------------------------");
    System.out.println(entity);
    System.out.println("----------------Array-----------------");

    Student[] students = restTemplate.getForObject("/", Student[].class);
    System.out.println(Arrays.toString(students));

    System.out.println("----------------Listas-----------------");

    ResponseEntity<List<Student>> responseEntity = restTemplate.exchange("/", HttpMethod.GET, null,
        new ParameterizedTypeReference<List<Student>>() {
        });

    System.out.println(responseEntity.getBody());
  }
}