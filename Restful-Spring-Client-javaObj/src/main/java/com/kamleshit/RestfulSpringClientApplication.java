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

	public static void main(String[] args) 
	{
		SpringApplication.run(RestfulSpringClientApplication.class, args);
		
		  RestTemplate rt = new RestTemplate();
		  
		  String restApiUrl="http://localhost:8080/api";
		  
		  ResponseEntity<String> forEntity = rt.getForEntity(restApiUrl, String.class);
		  
		  int status = forEntity.getStatusCodeValue();
		  
		  if(status == 200) 
		  { 
			  String body = forEntity.getBody();
			  System.out.println(body); 
		   }
		  
		  /*====================================================================================================*/	  
		  
			
		  RestTemplate rt2 = new RestTemplate();
		  
		  String restApiUrlTp1 =
		  "http://mu.mulesoft-training.com/essentials/united/flights/";
		  		  
		  ResponseEntity<String> forEntity2 = rt2.getForEntity(restApiUrlTp1,String.class);
		  
		  int status2 = forEntity2.getStatusCodeValue();
		  
		  if(status2==200)
		  {
			  System.out.println(forEntity2.getBody());
		  }
		  
		
		  
           /*====================================================================================================*/	  
		  
		
		  RestTemplate rt1 = new RestTemplate();
		  
		  String restApiUrlTp =
		  "http://mu.mulesoft-training.com/essentials/united/flights/";
		  
		  ResponseEntity<Flights> forEntity1 = rt1.getForEntity(restApiUrlTp,Flights.class);
		  
		  int status1 = forEntity.getStatusCodeValue();
		  
		  if(status == 200) { Flights body = forEntity1.getBody();
		  
		  List<Flight> flights = body.getFlights();
		  
		  flights.forEach(flight ->{
		  
		  System.out.println(flight);
		  
		  } );
		  
		  
		  }
		 
		 

	}

}
