package org.example.models.annotations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BeanWithCreator {
  public int id;
  public String name;

  @JsonCreator
  public BeanWithCreator(@JsonProperty("id") int id, @JsonProperty("beanName") String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public String toString() {
    return "BeanWithCreator(" +
        "id=" + id +
        ", name='" + name + '\'' +
        ')';
  }
}
