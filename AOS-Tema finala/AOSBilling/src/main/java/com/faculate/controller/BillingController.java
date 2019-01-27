package com.faculate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.faculate.model.Billing;
import com.faculate.repository.BillingRepository;


public class BillingController {
	@Autowired(required = true)
	private BillingRepository billingRepository;
	
	@Autowired 
	public BillingServiceProxy warehouseProxy;
	
	@Autowired
	public UserServiceProxy userProxy;
	
	@RequestMapping(path = "/billing/{idWarehouse}", method = RequestMethod.POST)
    public Billing getBill( @PathVariable Long idProduct)
    {
		Billing respons1=userProxy.retriveUser(idProduct);
        Billing respons2= warehouseProxy.retriveWarehouse(idProduct);  
        Billing saveBill=new Billing(respons1.getDestinatar(),respons1.getAddress(),respons2.getProduct());

        return  saveBill;
}
	@RequestMapping(path = "/updatebill", method =RequestMethod.PUT) 
	public @ResponseBody String addNewBilling(@RequestParam Long id, @RequestParam String destinatar, @RequestParam String address, @RequestParam String product) {
		Billing billing = billingRepository.findByID(id);
		billing.setDestinatar(destinatar);
		billing.setAddress(address);
		billing.setProduct(product);
		Billing respons1=userProxy.retriveUser(id);
        Billing respons2= warehouseProxy.retriveWarehouse(id); 
        Billing saveBill=new Billing(respons1.getDestinatar(),respons1.getAddress(),respons2.getProduct());
		billingRepository.save(saveBill);
		return "Updated";
	}
	
	@RequestMapping(path = "/removebill", method =RequestMethod.DELETE) 
	public @ResponseBody String removeBill(@RequestParam Long id) {
		Billing billing = billingRepository.findByID(id);
		billingRepository.delete(billing);
		return "Deleted";
	}
	 @RequestMapping(path = "/getbills",method = RequestMethod.GET)
	    public List<Billing> getBillings()
	    {
	        return (List<Billing>) billingRepository.findAll();
	    }
}