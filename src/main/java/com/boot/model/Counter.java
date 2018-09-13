package com.boot.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
(collection = "counters")
public class Counter {
  @org.springframework.data.annotation.Id 
  private String _id;
  private Long seq;
  /* getters & setters .. */
  public Long getSeq() {
	return seq;
  }
  public void setSeq(Long seq) {
	this.seq = seq;
  }
}