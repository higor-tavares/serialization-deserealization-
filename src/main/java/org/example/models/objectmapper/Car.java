package org.example.models.objectmapper;

public class Car {
  private String color;
  private String name;

  public Car() {}
  public Car(String color, String name) {
    this.color = color;
    this.name = name;
  }

  public String getColor() {
    return color;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Car(" +
        "color='" + color + '\'' +
        ", name='" + name + '\'' +
        ')';
  }
}