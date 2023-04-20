package objectmapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import java.io.File;
import java.io.IOException;
import org.example.models.objectmapper.Car;
import org.junit.jupiter.api.Test;

public class JsonIgnoreTest {

  @Test
  public void whenDeserializingWithNewFields_thenThrowError() throws IOException {
    var mapper = new ObjectMapper();
    assertThrows (UnrecognizedPropertyException.class, () -> {
      mapper.readValue(new File("out_files/new_car.json"), Car.class);
    });
  }
  @Test
  public void whenDeserializingWithNewFields_thenCorrect() throws IOException {
    var mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    var car = mapper.readValue(new File("out_files/new_car.json"), Car.class);
    System.out.println(car);
    assertEquals(car.getColor(), "Yellow");
  }
}
