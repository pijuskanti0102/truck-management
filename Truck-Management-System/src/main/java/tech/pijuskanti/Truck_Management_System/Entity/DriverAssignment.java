package tech.pijuskanti.Truck_Management_System.Entity;

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
import tech.pijuskanti.Truck_Management_System.enums.DriverEnum;

@Entity
@Table(name = "driver_assignment")
public class DriverAssignment {
	
	/*id	int	NO	PRI		auto_increment
	driver_id	int	NO	MUL		
	admin_id	int	NO	MUL		
	status	enum('AVAILABLE','DRIVING','INACTIVE')	NO			
	joining_date	datetime	NO			
	resign_date	datetime	YES	
	*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private DriverEnum status;
	
	@Column(name = "joining_date", nullable = true)
	private LocalDateTime joiningDate;
	
	@Column(name = "resign_date", nullable = true)
	private LocalDateTime resignDate;
	
	
	@ManyToOne
	@JoinColumn(name = "driver_id", nullable = false)
	private Driver driver;
	
	@ManyToOne
	@JoinColumn(name = "admin_id", nullable = false)
	private Admin admin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DriverEnum getStatus() {
		return status;
	}

	public void setStatus(DriverEnum status) {
		this.status = status;
	}

	public LocalDateTime getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDateTime joiningDate) {
		this.joiningDate = joiningDate;
	}

	public LocalDateTime getResignDate() {
		return resignDate;
	}

	public void setResignDate(LocalDateTime resignDate) {
		this.resignDate = resignDate;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
}
