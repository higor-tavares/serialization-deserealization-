package org.example.models.annotations;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"name","id"})
public class MyBean {
  public int id;
  private String name;
  public MyBean(int id, String name) {
    this.id = id;
    this.name = name;
  }

  @JsonGetter("name")
  public String getTheName() {
    return this.name;
  }
}
