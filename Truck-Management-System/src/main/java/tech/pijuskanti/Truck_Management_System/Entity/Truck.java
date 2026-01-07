package tech.pijuskanti.Truck_Management_System.Entity;

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
import tech.pijuskanti.Truck_Management_System.enums.TruckEnum;

@Entity
@Table(name = "truck")
public class Truck {

/*  Database Schema:
 	id	int	NO	PRI		auto_increment
	type	varchar(255)	NO			
	insurance	varchar(255)	YES			
	status	enum('AVAILABLE','RUNNING','MAINTENANCE')	NO			
	created_at	datetime	NO		CURRENT_TIMESTAMP	DEFAULT_GENERATED
	admin_id	int	NO	MUL		
*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "type", nullable = false)
	private String type;
	
	@Column(name = "insurance", nullable = true)
	private String insurance;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private TruckEnum status;
	
	@ManyToOne
	@JoinColumn(name = "admin_id", nullable = false)
	private Admin admin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public TruckEnum getStatus() {
		return status;
	}

	public void setStatus(TruckEnum status) {
		this.status = status;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
}
