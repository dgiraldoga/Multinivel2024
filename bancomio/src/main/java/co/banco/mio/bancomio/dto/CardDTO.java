package co.banco.mio.bancomio.dto;

import java.time.LocalDateTime;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardDTO {
	
    private Integer serialCard;
	private Character cardStatus;
	private Integer applicationId;
	private LocalDateTime cardRedate;

}
