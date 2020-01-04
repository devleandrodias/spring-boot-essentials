package com.spring.awesome.model;

import java.util.Objects;

/**
 * Student
 */
public class Student {
  private String name;

  public Student() {

  }

  public Student(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Student name(String name) {
    this.name = name;
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
    return Objects.equals(name, student.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }

  @Override
  public String toString() {
    return "{" + " name='" + getName() + "'" + "}";
  }

}