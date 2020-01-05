package com.spring.awesome.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * User
 */
@Entity // Entidade no banco de dados
public class User extends AbstractEntity {

  private static final long serialVersionUID = 1L;

  @NotEmpty
  @Column(unique = true)
  private String username;

  @NotEmpty
  @JsonIgnore
  private String password;

  @NotEmpty
  private String name;

  @NotEmpty
  private boolean admin;

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isAdmin() {
    return this.admin;
  }

  public boolean getAdmin() {
    return this.admin;
  }

  public void setAdmin(boolean admin) {
    this.admin = admin;
  }

}