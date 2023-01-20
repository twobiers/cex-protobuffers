package de.thkoeln.cexprotobuf.server.messages.json;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CreditCardPaymentDto implements Payment {
  private String number;
  private String owner;
  private String cvv;
  private String expiryDate;
}
