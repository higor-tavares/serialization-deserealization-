package org.example.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class ProductItemResponse {
  public String name;
  public int price;

  @JsonBackReference
  public OrderResponse order;

  public ProductItemResponse(String name, int price) {
    this.name = name;
    this.price = price;
  }
}
