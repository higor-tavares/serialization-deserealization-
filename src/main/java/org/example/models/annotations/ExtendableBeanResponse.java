package org.example.models.annotations;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import java.util.HashMap;
import java.util.Map;

public class ExtendableBeanResponse {
  public ExtendableBeanResponse(String name){
    this.name = name;
    this.properties = new HashMap<String, String>();
  }
  public String name;
  private Map<String, String> properties;

  public void add(String key, String value){
    this.properties.put(key, value);
  }

  @JsonAnyGetter
  public Map<String, String> getProperties() {
    return this.properties;
  }
}
