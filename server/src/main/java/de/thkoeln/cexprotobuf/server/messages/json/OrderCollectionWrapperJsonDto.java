package de.thkoeln.cexprotobuf.server.messages.json;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderCollectionWrapperJsonDto {
  private List<OrderJsonDto> orders;
}
