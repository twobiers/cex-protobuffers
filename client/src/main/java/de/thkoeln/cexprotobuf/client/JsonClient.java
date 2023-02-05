package de.thkoeln.cexprotobuf.client;

import de.thkoeln.cexprotobuf.client.messages.json.OrderCollectionWrapperJsonDto;
import de.thkoeln.cexprotobuf.client.messages.json.OrderJsonDto;
import java.util.List;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JsonClient {
  private final RestTemplate restTemplate;

  public JsonClient(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder
        .rootUri("http://localhost:3000")
        .build();
  }

  public OrderCollectionWrapperJsonDto getOrders() {
    var headers = new HttpHeaders();
    headers.setAccept(List.of(MediaType.APPLICATION_JSON));

    return restTemplate.exchange("/orders", HttpMethod.GET, new HttpEntity<>(headers),
        OrderCollectionWrapperJsonDto.class).getBody();
  }

  public void createOrder(OrderJsonDto order) {
    var headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    restTemplate.exchange("/orders", HttpMethod.POST, new HttpEntity<>(order, headers),
        Void.class);
  }
}
