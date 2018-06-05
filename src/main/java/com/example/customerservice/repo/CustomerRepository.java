package com.example.customerservice.repo;

import com.example.customerservice.domain.Customer;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by sbawaskar on 5/29/18.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
