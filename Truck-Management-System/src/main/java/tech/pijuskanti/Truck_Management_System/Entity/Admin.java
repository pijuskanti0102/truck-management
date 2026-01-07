package tech.pijuskanti.Truck_Management_System.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {

	
/*  Data-Base Schema:
	id	int	NO	PRI		auto_increment
	name	varchar(100)	NO			
	email_id	varchar(100)	NO	UNI		
	password	varchar(100)	NO			
	created_at	datetime	NO		CURRENT_TIMESTAMP	DEFAULT_GENERATED
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
}
