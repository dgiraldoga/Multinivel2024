package co.banco.mio.bancomio.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicationRequest {
    private Integer appId;
    private String appDescription;
    private Character status;
}
