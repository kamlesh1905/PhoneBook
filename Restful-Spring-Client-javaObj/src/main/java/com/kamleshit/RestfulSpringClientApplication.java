package com.kamleshit;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kamleshit.entity.binding.Flight;
import com.kamleshit.entity.binding.Flights;

@SpringBootApplication
public class RestfulSpringClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulSpringClientApplication.class, args);
		
		RestTemplate rt = new RestTemplate();
				
		//String restApiUrl="http://localhost:8080/api";
		
		String restApiUrlTp = "http://mu.mulesoft-training.com/essentials/united/flights/";
		
		/*
		 * ResponseEntity<String> forEntity = rt.getForEntity(restApiUrlTp,
		 * String.class);
		 * 
		 * int status = forEntity.getStatusCodeValue();
		 * 
		 * if(status == 200) { System.out.println(forEntity.getBody()); }
		 */		
		
		ResponseEntity<Flights> forEntity = rt.getForEntity(restApiUrlTp, Flights.class);
		
		int status = forEntity.getStatusCodeValue();
		
		if(status == 200) 
		{
			 Flights body = forEntity.getBody();
			 
			 List<Flight> flights = body.getFlights();
			 
			 flights.forEach(flight ->{
				 
				 System.out.println(flight);
				 
			 } );
			 
			
			 
			 
			
		}
		
		
	}

}
