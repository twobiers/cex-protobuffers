package de.thkoeln.cexprotobuf.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProtobufClientJob {
  private final ProtobufClient clientService;
  private final ProtobufOrderRandomizer randomizer;

  @Scheduled(fixedDelay = 10000)
  public void fetch() {
    var result = clientService.getOrders();

    log.info("[Proto] Received {} orders", result.getOrdersCount());
  }

  @Scheduled(fixedDelay = 10000, initialDelay = 5000)
  public void create() {
    var order = randomizer.randomOrder();

    clientService.creteOrder(order);

    log.info("[Proto] Created a random order");
  }
}
