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
public class ValidatorDTO {
	
    private Integer vlId;
	private String vlDesc;
	private String vlStatus;
	private Date vlRegDate;
	private Integer transportProviderId;

}
