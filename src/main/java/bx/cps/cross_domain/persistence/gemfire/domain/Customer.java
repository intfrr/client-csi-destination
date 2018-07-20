package bx.cps.cross_domain.persistence.gemfire.domain;

import java.util.concurrent.atomic.AtomicLong;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.annotation.Region;

/**
 * Created by nadir on 16/07/18.
 */
@Data
@EqualsAndHashCode(of = { "id" })
@ToString(of = { "id" })
@Region("customers")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

  private static AtomicLong COUNTER = new AtomicLong(0L);

  @Id
  private Long id;
  
  private Long CSID;
  
  private String name;
  private String street;
  private String city;
  private String zip;

  public Customer(String name) {
    this.id = COUNTER.getAndIncrement();
    this.name = name;
  }
  
}
