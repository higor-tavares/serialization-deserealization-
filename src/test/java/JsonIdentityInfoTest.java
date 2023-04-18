import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.TimeZone;
import org.example.models.ChartWithIdenity;
import org.example.models.ProductWithIdentity;
import org.junit.jupiter.api.Test;

public class JsonIdentityInfoTest {

  @Test
  public void whenSerializingUsingJsonIdentityInto_thenCorrect() throws JsonProcessingException {
    var p1 = new ProductWithIdentity(1234, "Pizza G", 2990);
    var p2 = new ProductWithIdentity(2423, "Refrigerante Guaraná", 1000);
    var chart = new ChartWithIdenity(1000, "Paulo Higor", Arrays.asList(p1,p2));
    var json = new ObjectMapper().setTimeZone(TimeZone.getTimeZone("GMT-3")).writeValueAsString(chart);
    System.out.println(json);
    assertThat(json, containsString("name"));
    assertThat(json, containsString("price"));
    assertThat(json, containsString("createdAt"));
  }
}
