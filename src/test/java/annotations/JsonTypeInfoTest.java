package annotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.example.models.annotations.Payment;
import org.junit.jupiter.api.Test;

public class JsonTypeInfoTest {

  @Test
  public void whenSerializingUsingJsonTypeInfo_thenCorrect() throws JsonProcessingException {
    Payment.CreditCard paymentType = new Payment.CreditCard(2500, 12);
    Payment payment = new Payment(paymentType);
    String json = new ObjectMapper().writeValueAsString(payment);
    System.out.println(json);
    assertThat(json, containsString("type"));
  }

  @Test
  public void whenDeserializingUsingJsonTypeInfo_thenCorrect() throws IOException {
    String json = "{\"paymentType\":{\"type\":\"PIX\",\"amount\":2500,\"qrcode\":\"qrcode-text\", \"expirationTimeInSeconds\":600}}";
    Payment payment = new ObjectMapper().readValue(json, Payment.class);
    System.out.println(payment);
    assertEquals(payment.paymentType.amount, 2500);
  }
}
