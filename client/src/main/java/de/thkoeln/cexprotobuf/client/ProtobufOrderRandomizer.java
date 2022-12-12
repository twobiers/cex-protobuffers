package de.thkoeln.cexprotobuf.client;

import com.google.protobuf.Timestamp;
import de.thkoeln.cexprotobuf.messages.proto.CupSizeProtoDto;
import de.thkoeln.cexprotobuf.messages.proto.OptionProtoDto;
import de.thkoeln.cexprotobuf.messages.proto.OrderProtoDto;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class ProtobufOrderRandomizer {

  public OrderProtoDto randomOrder() {
    var now = Instant.now();
    return OrderProtoDto.newBuilder()
        .setProduct(randomProductName())
        .setSize(randomCupSize())
        .setDate(Timestamp.newBuilder()
            .setNanos(now.getNano())
            .setSeconds(now.getEpochSecond())
            .build())
        .setCount(randomCount())
        .addAllOptions(randomOptions())
        .build();
  }

  private String randomProductName() {
    return "Product " + new Random().nextInt(100);
  }

  private CupSizeProtoDto randomCupSize() {
    return CupSizeProtoDto.values()[new Random().nextInt(CupSizeProtoDto.values().length)];
  }

  private int randomCount() {
    return new Random().nextInt(10);
  }

  private List<OptionProtoDto> randomOptions() {
    var list = new ArrayList<OptionProtoDto>();
    for (int i = 0; i < new Random().nextInt(5); i++) {
      list.add(OptionProtoDto.newBuilder()
          .setName("Option " + i)
          .setPrice(new Random().nextInt(100))
          .build());
    }
    return list;
  }
}
