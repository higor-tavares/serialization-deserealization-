package objectmapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.example.models.objectmapper.Car;
import org.junit.jupiter.api.Test;

public class JsonListObjectMapperTest {

  @Test
  public void test() throws IOException {
    var mapper = new ObjectMapper();
    List<Car> cars =  mapper.readValue(new File("out_files/cars.json"), new TypeReference<List<Car>>(){});
    cars.forEach(System.out::print);
    assertEquals(cars.size(),4);
  }
}
