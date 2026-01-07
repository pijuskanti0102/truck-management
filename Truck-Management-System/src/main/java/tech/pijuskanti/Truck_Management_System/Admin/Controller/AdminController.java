package tech.pijuskanti.Truck_Management_System.Admin.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.pijuskanti.Truck_Management_System.Admin.Service.AdminService;
import tech.pijuskanti.Truck_Management_System.Entity.Admin;

@RestController
@RequestMapping("/admin")
public class AdminController {

	AdminService adminService;
	
	public AdminController(	AdminService adminService) {
		this.adminService = adminService;
	}
	
	@PostMapping("/register")
	String registration(@RequestBody Admin admin) {
		
		adminService.registration(admin);
		return "done Pijus";
	}
	
	
	@PostMapping("/login")
	void login(@RequestBody Admin admin) {
		
		adminService.login(
				admin.getEmailId(), 
				admin.getPassword()
	    );
	}
	
	
}
