package com.example.customerservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.gemfire.mapping.annotation.Region;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by sbawaskar on 5/29/18.
 */
@Region("customers")
public class Customer {

  private static AtomicLong COUNTER = new AtomicLong(0L);

  @Id
  private Long id;

  public Customer() {
    this.id = COUNTER.getAndIncrement();
  }

  public Customer(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  private String name;

  private String address;
  private String city;
  private String zip;
}
