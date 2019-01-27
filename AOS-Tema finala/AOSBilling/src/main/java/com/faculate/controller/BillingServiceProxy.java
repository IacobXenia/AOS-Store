package com.faculate.controller;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.faculate.model.Billing;

@FeignClient(name="warehouse",url="localhost:2001")
public interface BillingServiceProxy {

	@GetMapping("/item/{itemId}")
    public Billing retriveWarehouse(@PathVariable("itemId") Long itemId);
}
