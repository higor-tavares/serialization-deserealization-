package org.example.models.annotations;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Date;

public class EventResponse {
  public String name;

  @JsonSerialize(using = CustomDataSerializer.class)
  public Date eventDate;

  public EventResponse(String name, Date eventDate){
    this.name = name;
    this.eventDate =  eventDate;
  }
}
