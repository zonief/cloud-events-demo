package com.example.cloudeventsdemo.controller;

import com.example.cloudeventsdemo.enums.EventType;
import com.example.cloudeventsdemo.model.CloudEventNotification;
import com.example.cloudeventsdemo.model.PaymentStatusUpdateNotification;
import com.example.cloudeventsdemo.repository.CloudEventRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cloudevents.CloudEvent;
import java.io.IOException;
import java.time.Instant;
import java.util.Arrays;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
public class CloudEventReceiver {

  private CloudEventRepository repository;
  private ObjectMapper objectMapper;

  @PostMapping("/echo")
  public void receiveNotification(@RequestBody CloudEvent event) throws IOException {

    PaymentStatusUpdateNotification notificationData = objectMapper.readValue(
        Objects.requireNonNull(event.getData()).toBytes(),
        PaymentStatusUpdateNotification.class);

    CloudEventNotification notification = CloudEventNotification.builder()
        .eventId(event.getId())
        .creationDate(Instant.now())
        .eventType(EventType.valueOf(event.getType()))
        .data(new String(event.getData().toBytes()))
        .source(event.getSource().toString())
        .version(event.getSpecVersion().name())
        .build();
    repository.saveAndFlush(notification);

    log.info("Payment {} has now status {}", notificationData.getId(),
        notificationData.getPaymentStatus());
  }
}
