package org.example.models.annotations;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

public class Payment {
  public PaymentType paymentType;

  public Payment(){

  }
  public Payment(PaymentType paymentType){
    this.paymentType = paymentType;
  }

  @JsonTypeInfo(
      use = JsonTypeInfo.Id.NAME,
      include = JsonTypeInfo.As.PROPERTY,
      property = "type"
  )
  @JsonSubTypes({
      @JsonSubTypes.Type(value = CreditCard.class, name = "CREDIT_CARD"),
      @JsonSubTypes.Type(value = PixPayment.class, name = "PIX")
  })
  public static class PaymentType {
    public int amount;
  }

  @JsonTypeName("CREDIT_CARD")
  public static class CreditCard extends PaymentType {
    public CreditCard(int amount, int installments) {
      this.installments = installments;
      this.amount = amount;
    }
    public int installments;

    @Override
    public String toString() {
      return "CreditCard(" +
          "installments=" + installments +
          ", amount=" + amount +
          ')';
    }
  }

  @JsonTypeName("PIX")
  public static class PixPayment extends PaymentType {

    public String qrcode;
    public int expirationTimeInSeconds;

    @Override
    public String toString() {
      return "PixPayment(" +
          "qrcode='" + qrcode + '\'' +
          ", expirationTimeInSeconds=" + expirationTimeInSeconds +
          ", amount=" + amount +
          ')';
    }
  }

  @Override
  public String toString() {
    return "Payment(" +
        "paymentType=" + paymentType +
        ')';
  }
}
