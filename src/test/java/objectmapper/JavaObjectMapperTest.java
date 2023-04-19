package objectmapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import org.example.models.objectmapper.Car;
import org.junit.jupiter.api.Test;

public class JavaObjectMapperTest {

  @Test
  public void test() throws IOException {
    var mapper = new ObjectMapper();
    var car = new Car("Yellow", "Renault Logan");
    mapper.writeValue(new File("out_files/car.json"), car);
  }
}
