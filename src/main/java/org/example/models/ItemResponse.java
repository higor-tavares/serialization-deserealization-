package org.example.models;

import com.fasterxml.jackson.annotation.JsonView;

public class ItemResponse {

  @JsonView(Access.Public.class)
  public String name;
  @JsonView(Access.Public.class)
  public int price;
  @JsonView(Access.Internal.class)
  public String ownerName;

  public ItemResponse(String name, int price, String ownerName) {
    this.name = name;
    this.price = price;
    this.ownerName = ownerName;
  }
}
