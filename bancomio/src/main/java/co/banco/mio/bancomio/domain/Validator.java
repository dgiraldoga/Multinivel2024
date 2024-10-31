package co.banco.mio.bancomio.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="validators")
public class Validator {
	
	@Id
	@Column(nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer vlId;
	
	@Column(name="vl_desc")
	private String vlDesc;
	
	@Column(name="vl_status")
	private String vlStatus;
	
	@Column(name="vl_regdate")
	private Date vlRegDate;
	
	@ManyToOne
	@JoinColumn(name="tp_id")
	private int tpId;

}
