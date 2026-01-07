package tech.pijuskanti.Truck_Management_System.driver.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import tech.pijuskanti.Truck_Management_System.Admin.Respository.AdminRepository;
import tech.pijuskanti.Truck_Management_System.Admin.Service.AdminService;
import tech.pijuskanti.Truck_Management_System.Entity.Admin;
import tech.pijuskanti.Truck_Management_System.Entity.Driver;
import tech.pijuskanti.Truck_Management_System.Entity.DriverAssignment;
import tech.pijuskanti.Truck_Management_System.driver.repository.DriverRepository;
import tech.pijuskanti.Truck_Management_System.driver_assignment.repository.DriverAssignmentRepository;
import tech.pijuskanti.Truck_Management_System.driver_assignment.service.DriverAssignmentService;
import tech.pijuskanti.Truck_Management_System.enums.DriverEnum;

@Service
public class DriverService {

	AdminRepository adminRepository;
	DriverRepository driverRepository;
	DriverAssignmentService driverAssignmentService;
	DriverAssignmentRepository driverAssignmentRepository;
	
	
	public DriverService(
			DriverRepository driverRepository,
			AdminRepository adminRepository,
			DriverAssignmentService driverAssignmentService,
			DriverAssignmentRepository driverAssignmentRepository){
		
		this.adminRepository = adminRepository;
		this.driverRepository = driverRepository;
		this.driverAssignmentService = driverAssignmentService;
		this.driverAssignmentRepository = driverAssignmentRepository;
	}
	
	
	public void register(Long adminId, Driver driver) {
		
		Optional<Admin> adminOp = adminRepository.findById(adminId);
		
		Admin admin = adminOp.get();
		
		String emailId = driver.getEmailId();
		
		boolean isEmailExists = driverRepository.existsByEmailId(emailId);
		
		if(!isEmailExists) {
			System.err.println("yyyyyyy");
			driver = driverRepository.save(driver);
			driverAssignmentService.assignDriver(admin, driver);
		}
		else {
			boolean isStatusInactive = driverRepository.
					existsByEmailIdAndStatus(emailId, DriverEnum.INACTIVE);
			
			if(isStatusInactive) {
				System.err.println("NOoooooooo");
				driver = driverRepository.findByEmailId(emailId);
				driver.setStatus(DriverEnum.ACTIVE);
				
				driver = driverRepository.save(driver);
				
				driverAssignmentService.assignDriver(admin, driver);
			}
			else {
				System.err.println("yyyyyggggggggyy");
				System.out.println("driver already exists!");
			}
		}		
	}
	
//	public void delete(Long driverId) {
//		boolean exists = driverRepository.existsById(driverId);
//		
//		if(exists) {
//			driverRepository.deleteById(driverId);
//		}
//	}
	
	
	public List<Driver> getAllDriver(Long adminId) {

		List<DriverAssignment> driverAssignmentList = driverAssignmentRepository
				.findByAdminIdAndResignDateIsNull(adminId);
		
		List<Long> driverIdList = new ArrayList<>();
		
		for(DriverAssignment da: driverAssignmentList) {
			driverIdList.add(da.getDriver().getId());
		}
		List<Driver> driverList = driverRepository.findByIdIn(driverIdList);
		
		return driverList;
	}
	
	public List<Driver> getDefiendDriver(
			Long adminId, DriverEnum status) {

		List<DriverAssignment> driverAssignmentList = driverAssignmentRepository
				.findByAdminIdAndResignDateIsNullAndStatus(
						adminId, status);
		
		List<Long> driverIdList = new ArrayList<>();
		
		for(DriverAssignment da: driverAssignmentList) {
			driverIdList.add(da.getDriver().getId());
		}
		List<Driver> driverList = driverRepository.findByIdIn(driverIdList);
		
		return driverList;
	}
	
	
	public Driver getSingleDriver(Long driverId) {
		boolean exists = driverRepository.existsById(driverId);
				
		if(exists) {
			Optional<Driver> driverOp = driverRepository.findById(driverId);
		    if(!driverOp.isEmpty()) {
		    	return driverOp.get();
		    }
		}
		
		return new Driver();
	}

}
