package com.spring.awesome.error;

/**
 * CustomErrorType
 */
public class CustomErrorType {

  private String errorMessage;

  public CustomErrorType(String error) {
    this.errorMessage = error;
  }

  public String getErrorMessage() {
    return this.errorMessage;
  }
}