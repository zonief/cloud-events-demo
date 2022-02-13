package com.example.cloudeventsdemo.controller;

import io.cloudevents.CloudEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CloudEventReceiver {

  @PostMapping("/echo")
  public void receiveNotification(@RequestBody CloudEvent event) {
    event.getData();
  }
}
