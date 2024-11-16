package co.banco.mio.bancomio.dto.request;


import co.banco.mio.bancomio.utils.ApplicationMessage;
import co.banco.mio.bancomio.utils.Message;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicationRequest {

    @NotNull(message = ApplicationMessage.APP_ID_NOT_NULL)
    @Positive( message = Message.POSITIVE_INT)
    private int appId;

    @NotBlank( message = ApplicationMessage.APP_NAME_NOT_NULL)
    @Size(min = 1, max = 100, message = ApplicationMessage.SIZE_APP_DESC)
    private String appDescription;

    private Character status;
}
