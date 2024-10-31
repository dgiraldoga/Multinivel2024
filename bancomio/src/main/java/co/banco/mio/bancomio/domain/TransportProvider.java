package co.banco.mio.bancomio.domain;

import java.util.Date;

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
@Table(name="transport_providers")
public class TransportProvider {
	
	@Id
	@Column(nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tpId;
	
	@Column(name="tp_desc")
	private String tpDesc;
	
	@Column(name="tp_status")
	private String tpStatus;
	
	@Column(name="tp_repdate")
	private Date tpRepDate;

}
