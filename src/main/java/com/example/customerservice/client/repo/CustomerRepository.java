package com.example.customerservice.client.repo;

import com.example.customerservice.client.domain.Customer;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by sbawaskar on 5/29/18.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
