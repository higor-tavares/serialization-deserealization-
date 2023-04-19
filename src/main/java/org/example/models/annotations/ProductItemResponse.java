package org.example.models.annotations;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
