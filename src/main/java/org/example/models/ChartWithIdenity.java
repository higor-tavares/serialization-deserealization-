package org.example.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.Date;
import java.util.List;


@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ChartWithIdenity {
  public int id;
  public String owner;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
  public Date createdAt;
  public List<ProductWithIdentity> products;

  public ChartWithIdenity(int id, String owner, List<ProductWithIdentity> products) {
    this.id = id;
    this.owner = owner;
    this.products = products;
    this.createdAt = new Date();
    products.forEach(p->p.owner=this);
  }
}
