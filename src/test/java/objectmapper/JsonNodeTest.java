package objectmapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class JsonNodeTest {

  @Test
  public void test() throws IOException {
    var mapper = new ObjectMapper();
    var jsonNode = mapper.readTree(new File("out_files/car.json"));
    var color = jsonNode.get("color").asText();
    System.out.println(color);
    assertEquals(color,"Yellow" );
  }
}
