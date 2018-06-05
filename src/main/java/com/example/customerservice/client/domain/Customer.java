package com.example.customerservice.client.domain;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.annotation.Region;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created by sbawaskar on 5/29/18.
 */
@Data
@EqualsAndHashCode(of = { "name" })
@ToString(of = { "name" })
@Region("customers")
public class Customer {

  private static AtomicLong COUNTER = new AtomicLong(0L);

  @Id
  private Long id;

  private String name;
  private String street;
  private String city;
  private String zip;

  public Customer(String name) {
    this.id = COUNTER.getAndIncrement();
    this.name = name;
  }
}
