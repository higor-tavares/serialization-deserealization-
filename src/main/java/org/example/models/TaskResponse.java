package org.example.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class TaskResponse {
  public String name;

  @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  public Date deadline;

  public TaskResponse(String name, Date deadline) {
    this.name = name;
    this.deadline = deadline;
  }
}
