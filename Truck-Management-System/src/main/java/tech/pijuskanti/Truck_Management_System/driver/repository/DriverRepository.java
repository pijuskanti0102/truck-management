package tech.pijuskanti.Truck_Management_System.driver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.pijuskanti.Truck_Management_System.Entity.Driver;
import tech.pijuskanti.Truck_Management_System.enums.DriverEnum;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long>{

	boolean existsByEmailId(String emailId);
	boolean existsByEmailIdAndStatus(String emailId, DriverEnum Status);
	Driver findByEmailId(String emailId);
	List<Driver> findByIdIn(List<Long> driverIdList);
}
