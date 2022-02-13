package com.example.cloudeventsdemo.enums;

import lombok.Getter;

@Getter
public enum EventType {

  PAYMENTSTATUS("paymentStatus"),
  BALANCEUPDATE("balanceUpdate");

  private final String value;

  EventType(String value) {
    this.value = value;
  }
}
