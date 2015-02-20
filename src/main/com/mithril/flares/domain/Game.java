package com.mithril.flares.domain;

public class Game {

  private String name;
  private String publisher;
  private String id;
  private String released;


  public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public String getPublisher() {
      return publisher;
  }

  public void setPublisher(String publisher) {
      this.publisher = publisher;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getReleased() {
    return released;
  }

  public void setReleased(String released) {
    this.released = released;
  }
}
