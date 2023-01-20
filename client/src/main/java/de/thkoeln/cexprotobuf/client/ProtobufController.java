package de.thkoeln.cexprotobuf.client;

import com.google.protobuf.Timestamp;
import de.thkoeln.cexprotobuf.client.messages.json.CashPaymentDto;
import de.thkoeln.cexprotobuf.client.messages.json.CupSizeJsonDto;
import de.thkoeln.cexprotobuf.client.messages.json.OptionJsonDto;
import de.thkoeln.cexprotobuf.client.messages.json.OrderJsonDto;
import de.thkoeln.cexprotobuf.messages.proto.CashProtoDto;
import de.thkoeln.cexprotobuf.messages.proto.CupSizeProtoDto;
import de.thkoeln.cexprotobuf.messages.proto.OptionProtoDto;
import de.thkoeln.cexprotobuf.messages.proto.OrderCollectionWrapperProtoDto;
import de.thkoeln.cexprotobuf.messages.proto.OrderProtoDto;
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
@RequestMapping("protobuf")
@RequiredArgsConstructor
public class ProtobufController {
  private final ProtobufClient protobufClient;

  @GetMapping(produces = "text/plain", path = "/getOrders")
  public String getOrders() {
    var orders = protobufClient.getOrders();
    return "Fetched %s orders: \n\n %s".formatted(orders.getOrdersList().size(), orders);
  }

  @PostMapping(produces = "text/plain", path = "/createOrder")
  public String createOrder() {
    var now = Instant.now();
    var order = OrderProtoDto.newBuilder()
        .setProduct("Cappuccino")
        .setSize(CupSizeProtoDto.TALL)
        .setDate(Timestamp.newBuilder()
            .setSeconds(now.getEpochSecond())
            .setNanos(now.getNano())
            .build())
        .setCount(2)
        .addOptions(OptionProtoDto.newBuilder()
            .setName("Milk")
            .setPrice(10)
            .build())
        .addOptions(OptionProtoDto.newBuilder()
            .setName("Sugar")
            .setPrice(5)
            .build())
        .setTopping(OptionProtoDto.newBuilder()
            .setName("Chocolate")
            .setPrice(20)
            .build())
        .setCash(CashProtoDto.newBuilder()
            .setAmount(100)
            .build())
        .setPrice(100)
        .setId(1)
        .build();
    protobufClient.creteOrder(order);
    return "Created an order: \n\n %s".formatted(order);
  }
}
