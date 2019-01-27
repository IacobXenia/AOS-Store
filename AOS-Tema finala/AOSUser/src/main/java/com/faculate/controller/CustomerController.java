package com.faculate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.faculate.customer.Customer;
import com.faculate.reporitory.CustomerRepository;

@RestController
public class CustomerController {
	
		@Autowired
		private CustomerRepository customerRepository;

		
		@RequestMapping(path = "/addperson", method =RequestMethod.POST)
		public @ResponseBody String addNewPerson(@RequestBody Customer customer) {
			customerRepository.save(customer);
			return "Saved";
		}

		@RequestMapping(path = "/updateperson", method =RequestMethod.PUT) 
		public @ResponseBody Customer addNewPerson(@RequestParam long id, @RequestParam String name, @RequestParam String address) {
			Customer customer = customerRepository.findByID(id);
			customer.setName(name);
			customer.setAddress(address);
		//	customer.setPort(Integer.parseInt(org.hibernate.cfg.Environment.getProperties("local.server.port")));
			customerRepository.save(customer);
			return customer;
		}
		
		@RequestMapping(path = "/removeperson", method =RequestMethod.DELETE) 
		public @ResponseBody String removePerson(@RequestParam long id) {
			Customer customer = customerRepository.findByID(id);
			customerRepository.delete(customer);
			return "Deleted";
		}
		
		
		@RequestMapping(path = "/allperson")
		public @ResponseBody Iterable<Customer> getAllPerson() {
			return customerRepository.findAll();
		}

	

}
