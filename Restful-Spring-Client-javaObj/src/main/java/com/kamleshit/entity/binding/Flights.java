package com.kamleshit.entity.binding;

import java.util.List;

public class Flights 
{
	private List<Flight> flights;

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	@Override
	public String toString() {
		return "Flights [flights=" + flights + "]";
	}
	
	

}
