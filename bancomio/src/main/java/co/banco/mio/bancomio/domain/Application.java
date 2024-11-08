package co.banco.mio.bancomio.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="applications")
public class Application {
	
	@Id
	@Column(name = "app_id", nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appId;
	
	@Column(name="app_desc")
	private String appDsc;
	
	@Column(name="app_status", length = 1, nullable=false)
	private Character appStatus;

}
