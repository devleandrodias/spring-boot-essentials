package com.spring.awesome.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * AbstractEntity
 */
@MappedSuperclass // Seja apenas ser estendidas e não ser mapeado para banco
public class AbstractEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (!(o instanceof AbstractEntity)) {
      return false;
    }
    AbstractEntity abstractEntity = (AbstractEntity) o;
    return Objects.equals(id, abstractEntity.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}