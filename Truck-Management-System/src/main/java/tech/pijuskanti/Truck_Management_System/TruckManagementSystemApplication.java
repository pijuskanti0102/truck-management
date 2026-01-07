package tech.pijuskanti.Truck_Management_System;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import tech.pijuskanti.Truck_Management_System.Entity.Admin;
import tech.pijuskanti.Truck_Management_System.Entity.Driver;
import tech.pijuskanti.Truck_Management_System.Entity.DriverAssignment;
import tech.pijuskanti.Truck_Management_System.Entity.Trip;
import tech.pijuskanti.Truck_Management_System.Entity.Truck;
import tech.pijuskanti.Truck_Management_System.Truck.Service.TruckService;
import tech.pijuskanti.Truck_Management_System.driver.service.DriverService;
import tech.pijuskanti.Truck_Management_System.driver_assignment.service.DriverAssignmentService;
import tech.pijuskanti.Truck_Management_System.enums.DriverEnum;
import tech.pijuskanti.Truck_Management_System.enums.TripEnum;
import tech.pijuskanti.Truck_Management_System.enums.TruckEnum;
import tech.pijuskanti.Truck_Management_System.trip.service.TripService;

@SpringBootApplication
public class TruckManagementSystemApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TruckManagementSystemApplication.class, args);
	
	
		//TripService service = context.getBean(TripService.class);
//		DriverAssignmentService service = context.getBean(DriverAssignmentService.class);
//		DriverAssignment driverAssignment = new DriverAssignment();
//
//		Long adminId = 1L;
//	    Long driverId = 23L;
//		driverAssignment.setStatus(DriverEnum.AVAILABLE);   // AVAILABLE / DRIVING
//		driverAssignment.setJoiningDate(LocalDateTime.now());

		//service.assignDriver(adminId, driverId, driverAssignment);
		
		Trip trip = new Trip();

		/* basic fields */
		trip.setMaterialTypes("Cement, Steel");
		trip.setCost(new BigDecimal("45000.00"));
		trip.setPickupLocation("Kolkata");
		trip.setDropLocation("Durgapur");
		trip.setStatus(TripEnum.CREATED);
		trip.setUpdatedAt(LocalDateTime.now());

		/* relational fields */
		//trip.setAdmin(admin);                 // Admin entity already fetched
		//trip.setTruck(truck);                 // Truck entity already fetched
		//trip.setDriverAssignment(driverAssignment); // DriverAssignment entity

		TripService service = context.getBean(TripService.class);
		
		//service.createTrip(1L, 1L, 1L, trip);
		
		List<Trip> list = service.getAllTrip(1L);
		
		for(Trip t: list) {
			System.out.println(t.getId()+" "+t.getStatus());
		}
		
		System.out.println("=============");
		
        List<Trip> list1 = service.getDefiendTrip(1L, TripEnum.CREATED);
        List<Trip> list2 = service.getDefiendTrip(1L, TripEnum.RUNNING);

        List<Trip> list3 = service.getDefiendTrip(1L, TripEnum.CANCELLED);
        List<Trip> list4 = service.getDefiendTrip(1L, TripEnum.COMPLETED);

		for(Trip t: list1) {
			System.out.println(t.getId()+" "+t.getStatus());
		}
		System.out.println("=============");

		for(Trip t: list2) {
			System.out.println(t.getId()+" "+t.getStatus());
		}
		System.out.println("=============");

		for(Trip t: list3) {
			System.out.println(t.getId()+" "+t.getStatus());
		}
		System.out.println("=============");

		for(Trip t: list4) {
			System.out.println(t.getId()+" "+t.getStatus());
		}
		System.out.println("=============");

		System.out.println("=============");
		System.out.println("=============");
		System.out.println("=============");
		System.out.println("=============");
		
		TruckService s = context.getBean(TruckService.class);
		List<Truck> allTruckList = s.getAllTruck(1L);

		List<Truck> availableTruckList = s.getDefiendTruck(1L, TruckEnum.AVAILABLE);
		List<Truck> runningTruckList = s.getDefiendTruck(1L, TruckEnum.RUNNING);

		for(Truck t: allTruckList) {
			System.out.println(t.getId()+" "+t.getStatus());
		}
		System.out.println("=============");
		
		for(Truck t: availableTruckList) {
			System.out.println(t.getId()+" "+t.getStatus());
		}
		System.out.println("=============");
		
		for(Truck t: runningTruckList) {
			System.out.println(t.getId()+" "+t.getStatus());
		}
		System.out.println("=============");
		
	}

}
