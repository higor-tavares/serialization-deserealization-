package org.example.models.annotations;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ProductWithIdentity {
  public int id;
  public String name;
  public int price;

  public ChartWithIdenity owner;
  public ProductWithIdentity(int id, String name, int price) {
    this.id = id;
    this.name = name;
    this.price = price;

  }
}
