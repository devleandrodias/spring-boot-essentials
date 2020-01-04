package com.spring.awesome.error;

/**
 * ResourceNotFoundDetails
 */
public class ResourceNotFoundDetails {

  private String title;
  private String details;
  private String developerMessage;
  private long timestamp;
  private int status;

  private ResourceNotFoundDetails() {

  }

  public String getTitle() {
    return this.title;
  }

  public String getDetails() {
    return this.details;
  }

  public String getDeveloperMessage() {
    return this.developerMessage;
  }

  public long getTimestamp() {
    return this.timestamp;
  }

  public int getStatus() {
    return this.status;
  }
}