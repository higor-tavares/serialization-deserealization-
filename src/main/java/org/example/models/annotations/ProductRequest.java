package org.example.models.annotations;

import com.fasterxml.jackson.annotation.JsonSetter;

public class ProductRequest {
  public int id;
  public String name;

  @JsonSetter("productName")
  public void setName(String name){
    this.name = name;
  }

  @Override
  public String toString() {
    return "ProductRequest(" +
        "id=" + id +
        ", name='" + name + '\'' +
        ')';
  }
}
