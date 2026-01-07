package tech.pijuskanti.Truck_Management_System.driver.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tech.pijuskanti.Truck_Management_System.Entity.Driver;
import tech.pijuskanti.Truck_Management_System.driver.service.DriverService;
import tech.pijuskanti.Truck_Management_System.enums.DriverEnum;

@RestController
@RequestMapping("/driver")
public class DriverController {
	
	DriverService driverService;
	
	public DriverController(DriverService driverService) {
		this.driverService = driverService;
	}
	
	@PostMapping("/register/{adminId}")
	public void register(@PathVariable Long adminId, @RequestBody Driver driver) {
		driverService.register(adminId, driver);
	}
	
	@GetMapping("/drivers/{adminId}")
	public List<Driver> getAllDriver(@PathVariable Long adminId) {
		return driverService.getAllDriver(adminId);
	}
	
	@GetMapping("/defined")
	public List<Driver> getDefinedDriver(@RequestParam Long adminId, 
			@RequestParam DriverEnum status){
		
		return driverService.getDefiendDriver(adminId, status);
	}
	
	@GetMapping("/singleDriver/{driverId}")
	public Driver getSingleDriver(@PathVariable Long driverId) {
		return driverService.getSingleDriver(driverId);
	}

}
