package de.thkoeln.cexprotobuf.client;

import de.thkoeln.cexprotobuf.client.messages.json.OrderCollectionWrapperJsonDto;
import de.thkoeln.cexprotobuf.client.messages.json.OrderJsonDto;
import de.thkoeln.cexprotobuf.messages.proto.OrderCollectionWrapperProtoDto;
import de.thkoeln.cexprotobuf.messages.proto.OrderProtoDto;
import java.util.List;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProtobufClient {

  private final RestTemplate restTemplate;

  public ProtobufClient(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder
        .rootUri("http://localhost:8080")
        .additionalMessageConverters(new ProtobufHttpMessageConverter())
        .build();
  }

  public OrderCollectionWrapperProtoDto getOrders() {
    var headers = new HttpHeaders();
    headers.setAccept(List.of(ProtobufHttpMessageConverter.PROTOBUF));

    return restTemplate.exchange("/orders", HttpMethod.GET, new HttpEntity<>(headers),
        OrderCollectionWrapperProtoDto.class).getBody();
  }

  public void creteOrder(OrderProtoDto order) {
    var headers = new HttpHeaders();
    headers.setContentType(ProtobufHttpMessageConverter.PROTOBUF);

    restTemplate.exchange("/orders", HttpMethod.POST, new HttpEntity<>(order, headers),
        Void.class);
  }
}
