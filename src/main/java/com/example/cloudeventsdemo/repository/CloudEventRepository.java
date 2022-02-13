package com.example.cloudeventsdemo.repository;

import com.example.cloudeventsdemo.model.CloudEventNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CloudEventRepository extends JpaRepository<CloudEventNotification, String> {

}
