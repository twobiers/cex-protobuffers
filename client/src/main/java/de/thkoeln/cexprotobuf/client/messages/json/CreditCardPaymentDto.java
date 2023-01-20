package de.thkoeln.cexprotobuf.client.messages.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardPaymentDto implements Payment {
  private String number;
  private String owner;
  private String cvv;
  private String expiryDate;
}
