package com.example.cloudeventsdemo.model;

import com.example.cloudeventsdemo.enums.PaymentStatus;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

  @Id
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private PaymentStatus paymentStatus;

}
