package tech.pijuskanti.Truck_Management_System.Admin.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.pijuskanti.Truck_Management_System.Admin.Respository.AdminRepository;
import tech.pijuskanti.Truck_Management_System.Entity.Admin;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository adminRepository;
	
	
	public void registration(Admin admin) {
		adminRepository.save(admin);
		System.out.println("done"+ admin.getName()+" "+admin.getId());
	}
	
	public void login(String emailId, String password) {
		boolean auth = adminRepository.existsByEmailIdAndPassword(emailId, password);
		
		if(auth) {
			System.out.println("login Successful");
		}
		else {
			System.out.println("login failed");
		}
	}

}
