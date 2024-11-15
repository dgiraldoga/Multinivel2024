package co.banco.mio.bancomio.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateValidadorRequest {

    private Integer vlId;
    private String valDescripcion;
    private Integer transportProviderId;
}