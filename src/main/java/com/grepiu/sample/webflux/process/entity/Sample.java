package com.grepiu.sample.webflux.process.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * Sample Entity 객체
 *
 */
@Document(value = "sample")
public class Sample {

  @Id
  private String id;
  private String subject;
  private String name;
  private String contents;

  public Sample() {
  }

  public Sample(String subject, String name, String contents) {
    this.subject = subject;
    this.name = name;
    this.contents = contents;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContents() {
    return contents;
  }

  public void setContents(String contents) {
    this.contents = contents;
  }
}
