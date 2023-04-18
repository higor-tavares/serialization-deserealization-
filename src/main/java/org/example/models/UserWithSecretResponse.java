package org.example.models;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("passFilter")
public class UserWithSecretResponse {
  public String name;
  public String email;
  public String password;

  public UserWithSecretResponse(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  }
}
