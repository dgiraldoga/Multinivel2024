package co.banco.mio.bancomio.domain;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cards")
public class Card {
	
	@Id
	@Column(name = "serial_card", nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer serialCard;
	
	@Column(name="card_status", length = 1, nullable = false)
	private Character cardStatus;
	
	@Column(name="card_regdate")
	private LocalDateTime cardRegDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="app_id", referencedColumnName = "appid")
	private Application application;

}
