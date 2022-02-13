package com.example.cloudeventsdemo.model;

import com.example.cloudeventsdemo.enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PaymentStatusUpdateNotification {

  private String id;
  private PaymentStatus paymentStatus;

}
