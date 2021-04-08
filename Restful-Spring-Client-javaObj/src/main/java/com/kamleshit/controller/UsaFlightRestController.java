package com.kamleshit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kamleshit.entity.binding.Flights;
import com.kamleshit.service.FlightsService;

@RestController
public class UsaFlightRestController {
	
	@Autowired
	private FlightsService service;
	
	@GetMapping("/flights")
	public Flights getUsaFlights()
	{
		return service.getFlights();
	}
	
	
	

}
