package de.thkoeln.cexprotobuf.client.messages.json;

import java.time.Instant;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderJsonDto {
  private String product;
  private CupSizeJsonDto size;
  private Instant date;
  private int count;
  private List<OptionJsonDto> options;
  private OptionJsonDto topping;
  private Payment payment;
}
