package org.example.models;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeEnumWithValue {
  TYPE1(1, "Type A"),
  TYPE2(2, "Type B");

  private final Integer id;
  private final String name;

  TypeEnumWithValue(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  @JsonValue
  public String getName() {
    return this.name;
  }

}
