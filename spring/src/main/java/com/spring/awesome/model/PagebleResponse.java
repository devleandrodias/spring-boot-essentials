package com.spring.awesome.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

/**
 * PagebleResponse
 */
public class PagebleResponse<T> extends PageImpl<T> {

  private static final long serialVersionUID = 1L;
  private boolean last;
  private boolean first;
  private int totalPage;

  public PagebleResponse(@JsonProperty("content") List<T> content, @JsonProperty("number") int page,
      @JsonProperty("size") int size, @JsonProperty("totalElements") long totalElements) {

    super(content, PageRequest.of(page, size), totalElements);
  }

  public PagebleResponse() {
    super(new ArrayList<>());
  }

  public boolean isLast() {
    return this.last;
  }

  public boolean getLast() {
    return this.last;
  }

  public void setLast(boolean last) {
    this.last = last;
  }

  public boolean isFirst() {
    return this.first;
  }

  public boolean getFirst() {
    return this.first;
  }

  public void setFirst(boolean first) {
    this.first = first;
  }

  public int getTotalPage() {
    return this.totalPage;
  }

  public void setTotalPage(int totalPage) {
    this.totalPage = totalPage;
  }

}