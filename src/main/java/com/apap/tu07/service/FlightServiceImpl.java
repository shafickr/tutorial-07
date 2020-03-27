package com.apap.tu07.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tu07.model.FlightModel;
import com.apap.tu07.repository.FlightDb;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
	@Autowired
	private FlightDb flightDb;

	@Override
	public FlightModel addFlight(FlightModel flight) {
		flightDb.save(flight);
		return flight;
	}

	public List<FlightModel> getAllFlight() {
		return flightDb.findAll();
	}

	@Override
	public void updateFlight(FlightModel flightModel) {
		FlightModel flight = flightDb.getOne(flightModel.getId());
		flight.setDestination(flightModel.getDestination());
		flight.setFlightNumber(flightModel.getFlightNumber());
		flight.setOrigin(flightModel.getOrigin());
		flight.setTime(flightModel.getTime());
		flightDb.save(flight);
	}

	@Override
	public FlightModel flightById(long id) {
		return flightDb.getOne(id);
	}

	@Override
	public void removeFlight(long id) {
		flightDb.deleteById(id);
	}

}