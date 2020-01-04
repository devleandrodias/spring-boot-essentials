package com.spring.awesome.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

/**
 * Student
 */
public class Student {

  private int id;
  private String name;
  public static List<Student> studentList;

  static {
    studentRepository();
  }

  public Student() {

  }

  public Student(int id, String name) {
    this(name);
    this.id = id;
  }

  public Student(String name) {
    this.name = name;
  }

  private static void studentRepository() {
    studentList = new ArrayList<>(asList(new Student(1, "Leandro"), new Student(2, "Thaísa")));
  }

  public String getName() {
    return this.name;
  }

  public int getId() {
    return this.id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Student name(String name, int id) {
    this.name = name;
    this.id = id;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof Student)) {
      return false;
    }
    Student student = (Student) o;
    return id == student.id;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }

}