package de.thkoeln.cexprotobuf.client.messages.json;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CashPaymentDto implements Payment {
  private float amount;
}
