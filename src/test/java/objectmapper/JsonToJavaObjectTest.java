package objectmapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import org.example.models.objectmapper.Car;
import org.junit.jupiter.api.Test;

public class JsonToJavaObjectTest {

  @Test
  public void test() throws IOException {
    var mapper = new ObjectMapper();
    var car = mapper.readValue(new File("out_files/car.json"), Car.class);
    System.out.println(car);
    assertEquals(car.getColor(), "Yellow");
  }
}
