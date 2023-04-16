import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.models.Access;
import org.example.models.ItemResponse;
import org.junit.jupiter.api.Test;

public class JsonViewTest {

  @Test
  public void whenSerializinUsingJsonView_thenCorrect() throws JsonProcessingException {
    var item = new ItemResponse("Livro: Senhor dos anéis. A sociedade do anel", 2789, "Paulo Higor");
    var json = new ObjectMapper().writerWithView(Access.Public.class).writeValueAsString(item);
    System.out.println(json);
    assertThat(json, containsString("name"));
    assertThat(json, containsString("price"));
    assertThat(json, not(containsString("ownerName")));
  }
}
