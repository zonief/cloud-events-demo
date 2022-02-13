package com.example.cloudeventsdemo.controller;

import com.example.cloudeventsdemo.model.PaymentStatusUpdateNotification;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cloudevents.CloudEvent;
import java.io.IOException;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CloudEventReceiver {

  @PostMapping("/echo")
  public void receiveNotification(@RequestBody CloudEvent event) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    PaymentStatusUpdateNotification notificationData = objectMapper.readValue(
        Objects.requireNonNull(event.getData()).toBytes(),
        PaymentStatusUpdateNotification.class);
    log.info("Payment {} has now status {}", notificationData.getId(),
        notificationData.getPaymentStatus());
  }
}
