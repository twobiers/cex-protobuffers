package de.thkoeln.cexprotobuf.server;

import com.google.protobuf.Timestamp;
import de.thkoeln.cexprotobuf.server.messages.proto.OptionProtoDto;
import de.thkoeln.cexprotobuf.server.messages.proto.OrderCollectionWrapperProtoDto;
import de.thkoeln.cexprotobuf.server.messages.proto.CupSizeProtoDto;
import de.thkoeln.cexprotobuf.server.messages.proto.OrderProtoDto;
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
        .build();
    protobufOrders.add(order);
  }

  @GetMapping(produces = "application/x-protobuf")
  public OrderCollectionWrapperProtoDto getOrders() {
    return OrderCollectionWrapperProtoDto.newBuilder()
        .addAllOrders(protobufOrders)
        .build();
  }

  @PostMapping(consumes = "application/x-protobuf")
  public void createOrder(@RequestBody OrderProtoDto order) {
    protobufOrders.add(order);
  }
}
