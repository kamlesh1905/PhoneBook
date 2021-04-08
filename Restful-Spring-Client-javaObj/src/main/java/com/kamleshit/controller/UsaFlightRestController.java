package com.kamleshit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kamleshit.entity.binding.Flights;
import com.kamleshit.service.FlightsService;

@RestController
public class UsaFlightRestController {
	
	@Autowired
	private FlightsService service;
	
	/*
	 * @GetMapping(value = "/flights", produces=
	 * {"application/xml","application/json"} ) public Flights getUsaFlights() {
	 * return service.getFlights(); }
	 */
		
	@GetMapping(value = "/flights", produces = { "application/xml", "application/json" })
	public ResponseEntity<Flights> getUsaFlights() {
		 Flights flights = service.getFlights();
		 return new ResponseEntity<>(flights,HttpStatus.OK);
	}
	

}
