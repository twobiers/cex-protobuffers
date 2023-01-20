package de.thkoeln.cexprotobuf.server;

import de.thkoeln.cexprotobuf.server.messages.json.CashPaymentDto;
import de.thkoeln.cexprotobuf.server.messages.json.CupSizeJsonDto;
import de.thkoeln.cexprotobuf.server.messages.json.OptionJsonDto;
import de.thkoeln.cexprotobuf.server.messages.json.OrderJsonDto;
import de.thkoeln.cexprotobuf.server.messages.json.OrderCollectionWrapperJsonDto;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
public class CoffeeOrderJsonController {

  private static final List<OrderJsonDto> jsonOrders = new ArrayList<>();

  static {
    var order = new OrderJsonDto(
        "Cappuccino",
        CupSizeJsonDto.TALL,
        Instant.now(),
        2,
        List.of(
            new OptionJsonDto("Milk", 10),
            new OptionJsonDto("Sugar", 5)
        ),
        new OptionJsonDto("Chocolate", 20),
        new CashPaymentDto(100)
    );
    jsonOrders.add(order);
  }

  @GetMapping(produces = "application/json")
  public OrderCollectionWrapperJsonDto getOrders() {
    return new OrderCollectionWrapperJsonDto(jsonOrders);
  }

  @PostMapping(consumes = "application/json")
  public void createOrder(@RequestBody OrderJsonDto order) {
    jsonOrders.add(order);
  }
}
