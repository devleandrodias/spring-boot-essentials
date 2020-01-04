package com.spring.awesome.model;

import javax.persistence.Entity;

/**
 * @author Leandro Dias for LuizaLabs on 03/01/2020
 */

@Entity
public class Student extends AbstractEntity {

  private static final long serialVersionUID = 1L;

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}