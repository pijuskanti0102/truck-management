package tech.pijuskanti.Truck_Management_System.trip.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import tech.pijuskanti.Truck_Management_System.Admin.Respository.AdminRepository;
import tech.pijuskanti.Truck_Management_System.Entity.Admin;
import tech.pijuskanti.Truck_Management_System.Entity.Driver;
import tech.pijuskanti.Truck_Management_System.Entity.DriverAssignment;
import tech.pijuskanti.Truck_Management_System.Entity.Trip;
import tech.pijuskanti.Truck_Management_System.Entity.Truck;
import tech.pijuskanti.Truck_Management_System.Truck.Repository.TruckRepository;
import tech.pijuskanti.Truck_Management_System.driver.repository.DriverRepository;
import tech.pijuskanti.Truck_Management_System.driver_assignment.repository.DriverAssignmentRepository;
import tech.pijuskanti.Truck_Management_System.enums.TripEnum;
import tech.pijuskanti.Truck_Management_System.trip.repository.TripRepository;

@Service
public class TripService {

	AdminRepository adminRepository;
	TruckRepository truckRepository;
	DriverRepository driverRepository;
	TripRepository tripRepository;
	DriverAssignmentRepository driverAssignmentRepository;
	
	public TripService(AdminRepository adminRepository,
			TruckRepository truckRepository,
			DriverRepository driverRepository,
			TripRepository tripRepository, 
			DriverAssignmentRepository driverAssignmentRepository) {
		
		this.adminRepository = adminRepository;
		this.truckRepository = truckRepository;
		this.driverRepository = driverRepository;
		this.tripRepository = tripRepository;
		this.driverAssignmentRepository = driverAssignmentRepository;
	}
	
	public void createTrip(Long adminId, Long truckId,
			Long driverId, Trip trip) {
		
		Admin admin = adminRepository.findById(adminId).get();
		Truck truck = truckRepository.findById(truckId).get();
		Driver driver = driverRepository.findById(driverId).get();
		
		DriverAssignment driverAssignment = 
				driverAssignmentRepository.
				     findByAdminIdAndDriverId(
						   admin.getId(), 
						   driver.getId()
				     );
				
		trip.setAdmin(admin);
		trip.setTruck(truck);
		//trip.setDriver(driver);
		trip.setDriverAssignment(driverAssignment);
		
		tripRepository.save(trip);
	}
	
	
	public List<Trip> getDefiendTrip(
			Long adminId, TripEnum status) {
		
		List<Trip> tripList = 
				tripRepository.
				findByAdminIdAndStatus(
						adminId,
						status
				);
		return tripList;
	}
	
    public List<Trip> getAllTrip(Long adminId) {
		
		List<Trip> allTripList = 
				tripRepository.findByAdminId(adminId);
		
		return allTripList;
	}
	
	public Trip getSingleTrip(Long tripId) {
		boolean exists = tripRepository.existsById(tripId);
		
		if(exists) {
			Optional<Trip> tripOp = tripRepository.findById(tripId);
			
			if(!tripOp.isEmpty()) {
				return tripOp.get();
			}
		}
		
		return new Trip();
	}
}
