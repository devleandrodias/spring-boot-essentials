package com.spring.awesome.model;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * @author Leandro Dias for LuizaLabs on 03/01/2020
 */

@Entity
public class Student extends AbstractEntity {

  private static final long serialVersionUID = 1L;

  @NotEmpty
  private String name;

  @Email
  private String email;

  public String getName() {
    return name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "{" + " name='" + getName() + "'" + ", email='" + getEmail() + "'" + "}";
  }

}