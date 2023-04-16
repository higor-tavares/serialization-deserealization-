package org.example.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

public class OrderResponse {
  public int id;
  public String client;

  @JsonManagedReference
  public List<ProductItemResponse> products;

  public OrderResponse(int id, String client, List<ProductItemResponse> products) {
    this.id = id;
    this.client = client;
    this.products = products;
    for(ProductItemResponse p : products){
      p.order = this;
    }
  }
}
