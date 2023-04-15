package org.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;



public class UserResponse {
  public String name;

  @JsonUnwrapped
  private Address address;

  public UserResponse(String name, Address addr){
    this.name = name;
    this.address = addr;
  }
  public static class Address {
    public String street;
    public String number;
    public String city;
    public String state;
    public String country;
    public String complement;

    public Address(String country, String state, String city, String street, String number, String complement) {
      this.country = country;
      this.state = state;
      this.city = city;
      this.street =  street;
      this.number = number;
      this.complement = complement;
    }
  }
}
