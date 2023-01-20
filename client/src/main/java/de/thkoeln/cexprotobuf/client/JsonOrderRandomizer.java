package de.thkoeln.cexprotobuf.client;

import de.thkoeln.cexprotobuf.client.messages.json.CashPaymentDto;
import de.thkoeln.cexprotobuf.client.messages.json.CupSizeJsonDto;
import de.thkoeln.cexprotobuf.client.messages.json.OptionJsonDto;
import de.thkoeln.cexprotobuf.client.messages.json.OrderJsonDto;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class JsonOrderRandomizer {

  public OrderJsonDto randomOrder() {
    return new OrderJsonDto(
        randomProductName(),
        randomCupSize(),
        Instant.now(),
        randomCount(),
        randomOptions(),
        new OptionJsonDto("Topping", 1),
        new CashPaymentDto(100)
    );
  }

  private String randomProductName() {
    return "Product " + new Random().nextInt(100);
  }

  private CupSizeJsonDto randomCupSize() {
    return CupSizeJsonDto.values()[new Random().nextInt(CupSizeJsonDto.values().length)];
  }

  private int randomCount() {
    return new Random().nextInt(10);
  }

  private List<OptionJsonDto> randomOptions() {
    var list = new ArrayList<OptionJsonDto>();
    for (int i = 0; i < new Random().nextInt(5); i++) {
      list.add(new OptionJsonDto("Option " + i, new Random().nextInt(100)));
    }
    return list;
  }
}
