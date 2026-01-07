package tech.pijuskanti.Truck_Management_System.Truck.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import tech.pijuskanti.Truck_Management_System.Admin.Respository.AdminRepository;
import tech.pijuskanti.Truck_Management_System.Entity.Admin;
import tech.pijuskanti.Truck_Management_System.Entity.Truck;
import tech.pijuskanti.Truck_Management_System.Truck.Repository.TruckRepository;
import tech.pijuskanti.Truck_Management_System.enums.TruckEnum;

@Service
public class TruckService {
	
	AdminRepository adminRepository; 
	TruckRepository truckRepository;
	
	public TruckService(
			             AdminRepository adminRepository,
			             TruckRepository truckRepository
			           ) {
		this.adminRepository = adminRepository;
		this.truckRepository = truckRepository;
	}
	
	
	//-----------------------------------------------------------------
	public void upload(long adminId, Truck truck) {
		Optional<Admin> adminOp = adminRepository.findById(adminId);
		
		if(adminOp.isEmpty()) {
			System.out.println("Invalid admin id");
		}
		else {
			Admin admin = adminOp.get();
			truck.setAdmin(admin);
			truckRepository.save(truck);
			System.out.println("done "+ truck.getId()+" "+truck.getInsurance());
		}
	}
	//-----------------------------------------------------------------
	
	
	
	
	//-----------------------------------------------------------------
	public void update(long truckId, Truck truck) {
		
	}
	//-----------------------------------------------------------------
	
	
	
	//------------------------------------------------------------------
	public void delete(long truckId) {
		boolean exists = truckRepository.existsById(truckId);
		if(exists) {
			truckRepository.deleteById(truckId);
		}
	}
	//------------------------------------------------------------------
	
	
	//------------------------------------------------------------------
		public List<Truck> getDefiendTruck(
				Long adminId, TruckEnum status) {
			List<Truck> truckList = 
					truckRepository.findByAdminIdAndStatus(
							adminId, status);
			
			return truckList;
		}
		//------------------------------------------------------------------

	
	//------------------------------------------------------------------
	public List<Truck> getAllTruck(Long adminId) {
		List<Truck> truckList = 
				truckRepository.findByAdminId(adminId);
		
		return truckList;
	}
	//------------------------------------------------------------------

	
	
	//------------------------------------------------------------------
    public Truck getSingleTruck(Long truckId) {
    	boolean exists = truckRepository.existsById(truckId);
    	if(exists) {
        	Truck truck = truckRepository.findById(truckId).get();
        	return truck;
    	}
    	return new Truck();
    }
	//------------------------------------------------------------------	
}
