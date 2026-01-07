package tech.pijuskanti.Truck_Management_System.trip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.pijuskanti.Truck_Management_System.Entity.Trip;
import tech.pijuskanti.Truck_Management_System.enums.TripEnum;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

	List<Trip> findByAdminIdAndStatus(Long adminId, TripEnum status);
	List<Trip> findByAdminId(Long adminId);
}
