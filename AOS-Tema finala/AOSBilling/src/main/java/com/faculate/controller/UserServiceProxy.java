package com.faculate.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.faculate.model.Billing;

@FeignClient(name="user",url="localhost:2001")
public interface UserServiceProxy {
	@GetMapping("/item/{itemId}")
    public Billing retriveUser(@PathVariable("itemId") Long itemId);
}
