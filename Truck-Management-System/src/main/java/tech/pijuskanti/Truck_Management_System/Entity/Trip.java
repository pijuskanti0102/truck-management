package tech.pijuskanti.Truck_Management_System.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import tech.pijuskanti.Truck_Management_System.enums.TripEnum;

@Entity
@Table(name = "trip")
public class Trip {

	/*
	Database Schema:
	id	int	NO	PRI		auto_increment
	material_types	varchar(255)	YES			
	cost	decimal(10,2)	NO			
	pickup_location	varchar(255)	NO			
	drop_location	varchar(255)	NO			
	status	enum('CREATED','ACCEPTED','RUNNING','CANCELLED','COMPLETED')	NO			
	created_at	datetime	NO		CURRENT_TIMESTAMP	DEFAULT_GENERATED
	updated_at	datetime	YES		CURRENT_TIMESTAMP	DEFAULT_GENERATED on update CURRENT_TIMESTAMP
	admin_id	int	NO	MUL		
	truck_id	int	NO	MUL		
	driver_assignment_id int NO MUL
	*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "material_types")
	private String materialTypes;
	
	@Column(name = "cost", nullable = false)
	private BigDecimal cost;
	
	@Column(name = "pickup_location", nullable = false)
	private String pickupLocation;
	
	@Column(name = "drop_location", nullable = false)
	private String dropLocation;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private TripEnum status;
	
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
	
	@ManyToOne
	@JoinColumn(name = "admin_id", nullable = false)
	private Admin admin;
	
	@ManyToOne
    @JoinColumn(name = "truck_id", nullable = false)
	private Truck truck;
	
	@ManyToOne
	@JoinColumn(name = "driver_assignment_id", nullable = false)
	private DriverAssignment driverAssignment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMaterialTypes() {
		return materialTypes;
	}

	public void setMaterialTypes(String materialTypes) {
		this.materialTypes = materialTypes;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public String getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public String getDropLocation() {
		return dropLocation;
	}

	public void setDropLocation(String dropLocation) {
		this.dropLocation = dropLocation;
	}

	public TripEnum getStatus() {
		return status;
	}

	public void setStatus(TripEnum status) {
		this.status = status;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Truck getTruck() {
		return truck;
	}

	public void setTruck(Truck truck) {
		this.truck = truck;
	}

	public DriverAssignment getDriverAssignment() {
		return driverAssignment;
	}

	public void setDriverAssignment(DriverAssignment driverAssignment) {
		this.driverAssignment = driverAssignment;
	}
}
