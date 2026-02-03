package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {
	
	
	@Autowired
	private CustomerService cs;
	
	@PostMapping("add")
	public void add(@RequestBody Customer c) {
		cs.add(c);
		
	}
	
	@PostMapping("addAll")
	public void addAll(@RequestBody List<Customer> list) {
		list.forEach(x->cs.add(x));
		
	}
	
	@GetMapping("display")
	public List<Customer> display(){
		return cs.display();
	}
	
	
	@DeleteMapping("delete/{id}")
	public Customer delete(@PathVariable Integer id) {
		Customer temp = cs.delete(id);
		return cs.delete(id);
	}
	
	@PostMapping("search/{id}")
	public Customer search(@PathVariable Integer id) {
		return cs.search(id);
	}
	
	@PostMapping("search/mob/{id}")
		public Customer searchMob(@PathVariable String mob) {
			return cs.findMob(mob);
		}
	

}
