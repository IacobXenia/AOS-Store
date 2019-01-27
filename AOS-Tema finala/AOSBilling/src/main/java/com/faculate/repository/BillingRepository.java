package com.faculate.repository;

import org.springframework.data.repository.CrudRepository;

import com.faculate.model.Billing;


public interface BillingRepository extends CrudRepository<Billing,Integer>  {
	Billing findByID(Long id);
}
