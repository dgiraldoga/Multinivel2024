package co.banco.mio.bancomio.domain;


import java.time.LocalDateTime;
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
@Table(name="line_details")
public class LineDetail {
	
	@Id
	@Column(name = "ld_id", nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ldId;
	
	@Column(name="ld_desc")
	private String ldDsc;
	
	@Column(name="ld_status", length = 1, nullable = false)
	private Character ldStatus;
	
	@Column(name="ld_regdate")
	private LocalDateTime ldRegDate;

}
