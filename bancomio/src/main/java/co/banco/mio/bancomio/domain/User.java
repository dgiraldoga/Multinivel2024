package co.banco.mio.bancomio.domain;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users", schema = "mio")
public class User {
	
	@Id
	@Column(name = "user_id", nullable=false)
	private Integer userId;
	
	@Column(name="name_user")
	private String name;
	
	@Column(name="lastname_user")
	private String lastName;
	
	@Column(name="city")
	private String city;
	
	@Column(name="status", length = 1, nullable = false)
	private Character status;
	
	@Column(name="user_regdate")
	private LocalDateTime userRegDate;
	

}
