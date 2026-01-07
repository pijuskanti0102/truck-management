package tech.pijuskanti.Truck_Management_System.trip.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tech.pijuskanti.Truck_Management_System.Entity.Trip;
import tech.pijuskanti.Truck_Management_System.enums.TripEnum;
import tech.pijuskanti.Truck_Management_System.trip.service.TripService;

@RestController
@RequestMapping("/trip")
public class TripController {

    private final TripService tripService;
	
	public TripController(TripService tripService) {
		this.tripService = tripService; 
	}
	
	@PostMapping("/create")
	public void createTrip(
			@RequestParam Long adminId,
			@RequestParam Long truckId,
			@RequestParam Long driverId,
			@RequestBody Trip trip) {
		tripService.createTrip(adminId, truckId, driverId, trip);
	}
	
	@GetMapping("/defined")
	public List<Trip> getDefiendTrip(@RequestParam Long adminId, 
			@RequestParam TripEnum status) {
		return tripService.getDefiendTrip(adminId, status);
	}
	
	@GetMapping("/allTrip/{adminId}")
	public List<Trip> getAllTrip(@PathVariable Long adminId) {
		return tripService.getAllTrip(adminId);
	}
	
	@GetMapping("/singleTrip/{tripId}")
	public Trip getSingleTrip(@PathVariable Long tripId) {
		return tripService.getSingleTrip(tripId);
	}

}
