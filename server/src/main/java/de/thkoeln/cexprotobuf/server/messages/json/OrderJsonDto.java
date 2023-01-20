package de.thkoeln.cexprotobuf.server.messages.json;

import java.time.Instant;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderJsonDto {
  private String product;
  private CupSizeJsonDto size;
  private Instant date;
  private int count;
  private List<OptionJsonDto> options;
  private OptionJsonDto topping;
  Payment payment;
}
