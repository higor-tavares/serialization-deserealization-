package org.example.models.annotations;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Date;

public class EventRequest {
  public String name;

  @JsonDeserialize(using = CustomDateDeserializer.class)
  public Date eventDate;

  @Override
  public String toString() {
    return "EventRequest(" +
        "name='" + name + '\'' +
        ", eventDate=" + eventDate.toString() +
        ')';
  }
}
