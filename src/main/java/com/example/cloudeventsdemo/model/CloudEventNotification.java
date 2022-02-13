package com.example.cloudeventsdemo.model;

import com.example.cloudeventsdemo.enums.EventType;
import java.time.Instant;
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
public class CloudEventNotification {

  @Id
  @Column(name = "c_id", nullable = false, length = 36)
  private String eventId;

  @Column(name = "c_version", nullable = false)
  private String version;

  @Column(name = "c_creation_date")
  private Instant creationDate;

  @Column(name = "c_event_type")
  @Enumerated(EnumType.STRING)
  private EventType eventType;

  @Column(name = "c_data")
  private String data;

  @Column(name = "c_source")
  private String source;


}
