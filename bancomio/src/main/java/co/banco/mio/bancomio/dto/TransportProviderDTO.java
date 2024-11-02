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
public class TransportProviderDTO {
	
    private Integer tpId;
	private String tpDesc;
	private String tpStatus;
	private Date tpRepDate;

}
