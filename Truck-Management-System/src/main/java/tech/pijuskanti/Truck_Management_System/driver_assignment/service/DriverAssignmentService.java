package tech.pijuskanti.Truck_Management_System.driver_assignment.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import tech.pijuskanti.Truck_Management_System.Admin.Respository.AdminRepository;
import tech.pijuskanti.Truck_Management_System.Entity.Admin;
import tech.pijuskanti.Truck_Management_System.Entity.Driver;
import tech.pijuskanti.Truck_Management_System.Entity.DriverAssignment;
import tech.pijuskanti.Truck_Management_System.driver.repository.DriverRepository;
import tech.pijuskanti.Truck_Management_System.driver_assignment.repository.DriverAssignmentRepository;
import tech.pijuskanti.Truck_Management_System.enums.DriverEnum;

@Service
public class DriverAssignmentService {

    AdminRepository adminRepository;
    DriverRepository driverRepository;
	DriverAssignmentRepository driverAssignmentRepository;
	
	
	public DriverAssignmentService(
			AdminRepository adminRepository,
			DriverRepository driverRepository,
			DriverAssignmentRepository driverAssignmentRepository){
		
		this.adminRepository = adminRepository;
		this.driverRepository = driverRepository;
		this.driverAssignmentRepository = driverAssignmentRepository;		
	}
	
	public void assignDriver(Admin admin, Driver driver){
		
		DriverAssignment driverAssignment = new DriverAssignment();
		
		driverAssignment.setAdmin(admin);
		driverAssignment.setDriver(driver);
		driverAssignment.setStatus(DriverEnum.AVAILABLE);   // AVAILABLE / DRIVING
		driverAssignment.setJoiningDate(LocalDateTime.now());
		driverAssignmentRepository.save(driverAssignment);
	}
}
