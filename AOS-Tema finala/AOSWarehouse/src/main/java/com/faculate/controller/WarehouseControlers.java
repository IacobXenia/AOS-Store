package com.faculate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.faculate.product.Product;
import com.faculate.repository.WarehouseRepository;

@RestController
public class WarehouseControlers{
	@Autowired(required = true)
	private WarehouseRepository warehouseRepository;
	

	 @RequestMapping(path = "/addProduct",method = RequestMethod.POST)
	    public Product addProduct(@RequestBody Product myStore)
	    {
	        return warehouseRepository.save(myStore);
	    }
	
	@RequestMapping(path = "/updateproduct", method =RequestMethod.PUT) 
	public @ResponseBody String addNewProduct(@RequestParam long id, @RequestParam int amount, @RequestParam String name, @RequestParam String region) {
		Product product = warehouseRepository.findByID(id);
		product.setAmount(amount);
		product.setName(name);
		product.setRegion(region);
		warehouseRepository.save(product);
		return "Updated";
	}
	
	@RequestMapping(path = "/removeproduct", method =RequestMethod.DELETE) 
	public @ResponseBody String removeProduct(@RequestParam long id) {
		Product product = warehouseRepository.findByID(id);
		warehouseRepository.delete(product);
		return "Deleted";
	}
	
	  @RequestMapping(path = "/getproducts",method = RequestMethod.GET)
	    public List<Product> getProducts()
	    {
	        return (List<Product>) warehouseRepository.findAll();
	    }
}
	    

