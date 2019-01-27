package com.faculate.reporitory;


import org.springframework.data.repository.CrudRepository;

import com.faculate.customer.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	Customer findByID(long id);
}
