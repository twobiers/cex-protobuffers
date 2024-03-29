package de.thkoeln.cexprotobuf.server;

import com.google.protobuf.Timestamp;
import de.thkoeln.cexprotobuf.messages.proto.CashProtoDto;
import de.thkoeln.cexprotobuf.messages.proto.CupSizeProtoDto;
import de.thkoeln.cexprotobuf.messages.proto.OptionProtoDto;
import de.thkoeln.cexprotobuf.messages.proto.OrderCollectionWrapperProtoDto;
import de.thkoeln.cexprotobuf.messages.proto.OrderProtoDto;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
@Slf4j
public class CoffeeOrderProtobufController {

  private static final List<OrderProtoDto> protobufOrders = new ArrayList<>();

  static {
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
    protobufOrders.add(order);
  }

  @GetMapping(produces = "application/x-protobuf")
  public OrderCollectionWrapperProtoDto getOrders() {
    log.info("Responding with orders: {}", protobufOrders);
    return OrderCollectionWrapperProtoDto.newBuilder()
        .addAllOrders(protobufOrders)
        .build();
  }

  @PostMapping(consumes = "application/x-protobuf")
  public void createOrder(@RequestBody OrderProtoDto order) {
    log.info("Received order: {}", order);
    protobufOrders.add(order);
  }
}
