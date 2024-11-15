package co.banco.mio.bancomio.domain;

import java.time.LocalDateTime;
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
	@Column(name = "vl_id", nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer vlId;
	
	@Column(name="vl_desc")
	private String vlDesc;
	
	@Column(name="vl_status", length = 1, nullable=false)
	private Character vlStatus;
	
	@Column(name="vl_regdate")
	private LocalDateTime vlRegDate;
	
	@ManyToOne
	@JoinColumn(name="tp_id")
	private TransportProvider transportProvider;

}
