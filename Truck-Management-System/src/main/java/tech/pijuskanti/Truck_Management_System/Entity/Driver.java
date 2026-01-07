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
import tech.pijuskanti.Truck_Management_System.enums.DriverEnum;

@Entity
@Table(name = "driver")
public class Driver {
	
/*
 	Database Schema:
	id	int	NO	PRI		auto_increment
	name	varchar(100)	NO			
	email_id	varchar(100)	NO	UNI		
	password	varchar(100)	NO			
	status	enum('AVAILABLE','DRIVING')	NO				
*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "email_id", nullable = false, unique = true)
	private String emailId;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private DriverEnum status;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public DriverEnum getStatus() {
		return status;
	}

	public void setStatus(DriverEnum status) {
		this.status = status;
	}
}
