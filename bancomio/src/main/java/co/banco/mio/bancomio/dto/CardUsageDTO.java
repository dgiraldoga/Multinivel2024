package co.banco.mio.bancomio.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardUsageDTO {

	private Integer cardId;
	private Integer lineDetailId;
	private Integer userId;
	private Integer validatorId;
	private Date cuDateTime;
	private Integer fareValue;
	private Integer typeUsage;
	private Integer tsn;

}
