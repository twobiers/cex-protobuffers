package de.thkoeln.cexprotobuf.client;

import de.thkoeln.cexprotobuf.client.messages.json.CashPaymentDto;
import de.thkoeln.cexprotobuf.client.messages.json.CupSizeJsonDto;
import de.thkoeln.cexprotobuf.client.messages.json.OptionJsonDto;
import de.thkoeln.cexprotobuf.client.messages.json.OrderJsonDto;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("json")
@RequiredArgsConstructor
public class JsonController {

  private final JsonClient jsonClient;

  @GetMapping(produces = "text/plain", path = "/getOrders")
  public String getOrders() {
    var orders = jsonClient.getOrders();
    return "Fetched %s orders: \n\n %s".formatted(orders.getOrders().size(), orders);
  }

  @PostMapping(produces = "text/plain", path = "/createOrder")
  public String createOrder() {
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
    jsonClient.createOrder(order);
    return "Created an order: \n\n %s".formatted(order);
  }
}
