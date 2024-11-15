package co.banco.mio.bancomio.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateCardUsageRequest {
    private Integer serialCardNumber;
    private Integer lineDetailId;
    private Integer userId;
    private Integer validator_id;
    private Integer typeUsage;

}