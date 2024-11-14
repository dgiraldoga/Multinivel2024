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
@Table(name="cards_usages")
public class CardUsage {
	
	@Id
	@Column(nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="serial_card")
	private Card card;
	
	@ManyToOne
	@JoinColumn(name="ld_id")
	private LineDetail lineDetail;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="vl_id")
	private Validator validator;
	
	@Column(name="cu_datetime")
	private LocalDateTime cuDateTime;
	
	@Column(name="fare_value")
	private int fareValue;
	
	@Column(name="type_usage")
	private int typeUsage;

}
