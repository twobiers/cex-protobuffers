package de.thkoeln.cexprotobuf.server.messages.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CashPaymentDto implements Payment {
  private float amount;
}
