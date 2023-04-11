package org.example.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Date;

public class Event {
  public String name;

  @JsonSerialize(using = CustomDataSerializer.class)
  public Date eventDate;

  public Event(String name, Date eventDate){
    this.name = name;
    this.eventDate =  eventDate;
  }
}
