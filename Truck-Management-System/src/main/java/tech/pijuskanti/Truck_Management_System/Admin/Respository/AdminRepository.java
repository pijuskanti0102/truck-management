package tech.pijuskanti.Truck_Management_System.Admin.Respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.pijuskanti.Truck_Management_System.Entity.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

	boolean existsByEmailIdAndPassword(String emailId, String password);
	
}
