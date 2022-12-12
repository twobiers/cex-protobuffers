package de.thkoeln.cexprotobuf.client.messages.json;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCollectionWrapperJsonDto {
  private List<OrderJsonDto> orders;
}
