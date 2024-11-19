package co.banco.mio.bancomio.dto.request;

import co.banco.mio.bancomio.utils.ApplicationMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplicationRequest {

    @NotBlank( message = ApplicationMessage.APP_NAME_NOT_NULL)
    @Size(min = 1, max = 100, message = ApplicationMessage.SIZE_APP_DESC)
    private String appDescription;
    private Character status;
}
