package org.example.models.annotations;

import java.util.Date;

public class OrderResponseWithCustomAnnotation {
  public int id;
  public String client;
  public int price;

  @BrazilianDate
  public Date createdAt;

  public OrderResponseWithCustomAnnotation(int id, String client, int price) {
    this.id = id;
    this.client = client;
    this.price = price;
    this.createdAt = new Date();
  }
}
