package tech.pijuskanti.Truck_Management_System.Truck.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.pijuskanti.Truck_Management_System.Entity.Truck;
import tech.pijuskanti.Truck_Management_System.enums.TruckEnum;

@Repository
public interface TruckRepository extends JpaRepository<Truck, Long>{

	List<Truck> findByAdminId(Long adminId);
	List<Truck> findByAdminIdAndStatus(Long adminId, TruckEnum status);

}
