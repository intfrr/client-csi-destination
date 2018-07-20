package bx.cps.cross_domain.persistence.gemfire.repo;

import bx.cps.cross_domain.persistence.gemfire.domain.Customer;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by nadir on 16/07/18.
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
