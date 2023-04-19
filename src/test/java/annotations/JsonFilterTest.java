package annotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.example.models.annotations.UserWithSecretResponse;
import org.junit.jupiter.api.Test;

public class JsonFilterTest {
  @Test
  public void whenSerializingUsingFilter_thenCorrect() throws JsonProcessingException {
    var user = new UserWithSecretResponse("Paulo Higor","phtadmin@gmail.com", "12345");
    var filters = new SimpleFilterProvider().addFilter("passFilter", SimpleBeanPropertyFilter.serializeAllExcept("password"));
    var json = new ObjectMapper().writer(filters).writeValueAsString(user);
    System.out.println(json);
    assertThat(json, containsString("email"));
    assertThat(json, containsString("name"));
    assertThat(json, not(containsString("password")));
  }
}
