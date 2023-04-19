package annotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.models.annotations.UserWithRoot;
import org.junit.jupiter.api.Test;

public class JsonRootNameXMLTest {
  @Test
  public void whenSerializingUsingJsonRootName_thenCorrect() throws JsonProcessingException {
    var user = new UserWithRoot(1, "Higor");
    var mapper = new XmlMapper();
    //should enable feature
    mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
    String serialized = mapper.writeValueAsString(user);
    System.out.println(serialized);
    assertThat(serialized, containsString("user"));
  }
}
