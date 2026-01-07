package tech.pijuskanti.Truck_Management_System.driver_assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.pijuskanti.Truck_Management_System.Entity.DriverAssignment;
import tech.pijuskanti.Truck_Management_System.enums.DriverEnum;

@Repository
public interface DriverAssignmentRepository extends JpaRepository<DriverAssignment, Long>{

	List<DriverAssignment> findByAdminIdAndResignDateIsNull(Long adminId);
	List<DriverAssignment> findByAdminIdAndResignDateIsNullAndStatus(Long adminId, DriverEnum status);
	DriverAssignment findByAdminIdAndDriverId(Long adminId, Long driverId);	
}
