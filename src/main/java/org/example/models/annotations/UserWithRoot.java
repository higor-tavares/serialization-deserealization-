package org.example.models.annotations;

import com.fasterxml.jackson.annotation.JsonRootName;

/*
 * When wrap root value is enabled the default value
 * is the name of the class
 */
@JsonRootName(value = "user", namespace = "users")
public class UserWithRoot {
  public int id;
  public String name;

  public UserWithRoot(int id, String name) {
    this.id = id;
    this.name = name;
  }
}
