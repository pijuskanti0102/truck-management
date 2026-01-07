package tech.pijuskanti.Truck_Management_System.Truck.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tech.pijuskanti.Truck_Management_System.Entity.Truck;
import tech.pijuskanti.Truck_Management_System.Truck.Service.TruckService;
import tech.pijuskanti.Truck_Management_System.enums.TruckEnum;

@RestController
@RequestMapping("/truck")
public class TruckController {

	TruckService truckService;
	
	public TruckController(TruckService truckService){
		this.truckService = truckService;
	}
	
	@PostMapping("/upload/{adminId}")
	public void upload(@PathVariable Long adminId,
			@RequestBody Truck truck) {
		truckService.upload(adminId, truck);
	}
	
	@GetMapping("/defined")
	List<Truck> getDefinedTruck(@RequestParam Long adminId, 
		    @RequestParam  TruckEnum status) {
		return truckService.getDefiendTruck(adminId, status);
	}
	
	@GetMapping("/allTruck/{adminId}")
	List<Truck> getAllTruck(@PathVariable Long adminId){
		System.out.println("jjjjjj");
		return truckService.getAllTruck(adminId);
	}
	
	@GetMapping("/singleTruck/{truckId}")
	Truck getSingleTruck(@PathVariable Long truckId) {
		return truckService.getSingleTruck(truckId);
	}
}
