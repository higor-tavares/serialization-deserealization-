package org.example.models;

import static java.util.Map.*;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import java.util.HashMap;
import java.util.Map;

public class ExtendableBean2 {
  public String name;
  private final Map<String, String> properties = new HashMap<String, String>();

  @JsonAnySetter
  public void add(String key, String value){
    properties.put(key, value);
  }

  public Map<String, String> getProperties() {
    return properties;
  }

  @Override
  public String toString() {
    StringBuilder props = new StringBuilder("[");
    boolean first = true;
    for(Entry<String, String> entry : properties.entrySet()){
      if(!first)
        props.append(",");
      props.append("\"").append(entry.getKey()).append("\"").append(":").append("\"").append(entry.getValue()).append("\"");
      first = false;
    }
    props.append("]");
    return "ExtendableBean2 (" +
        "name='" + name + '\'' +
        ", properties=" + props +
        ')';
  }
}
