package de.thkoeln.cexprotobuf.server.messages.json;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OptionJsonDto {
  private String name;
  private int price;
}
