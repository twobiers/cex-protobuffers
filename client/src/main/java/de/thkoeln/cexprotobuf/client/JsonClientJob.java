package de.thkoeln.cexprotobuf.client;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class JsonClientJob {
  private final JsonClient clientService;
  private final JsonOrderRandomizer randomizer;

  @Scheduled(fixedDelay = 10000)
  public void fetch() {
    var result = clientService.getOrders();

    log.info("[JSON] Received {} orders", result.getOrders().size());
  }

  @Scheduled(fixedDelay = 10000, initialDelay = 5000)
  public void create() {
    var order = randomizer.randomOrder();

    clientService.createOrder(order);

    log.info("[JSON] Created a random order");
  }
}
