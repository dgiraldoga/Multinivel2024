package co.banco.mio.bancomio.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="applications")
public class Application {
	
	@Id
	@Column(name = "app_id", nullable=false)
	private Integer appId;
	
	@Column(name="app_desc")
	private String appDsc;
	
	@Column(name="app_status", length = 1, nullable=false)
	private Character appStatus;

	@OneToMany (mappedBy = "application")
	private List<Card> cardList;

}
