package co.banco.mio.bancomio.dto.request;

import co.banco.mio.bancomio.utils.Message;
import co.banco.mio.bancomio.utils.TransportProviderMessage;
import co.banco.mio.bancomio.utils.ValidatorMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateValidadorRequest {

    @NotNull(message = ValidatorMessage.VL_ID_NOT_NULL)
    @Size(min = 4, max = 4, message = ValidatorMessage.SIZE_VALIDATOR_ID)
    private Integer vlId;

    @NotBlank (message = ValidatorMessage.DESC_VALIDATOR)
    @Size(min = 4, max = 4, message = ValidatorMessage.SIZE_DESC_VALIDATOR)
    private String valDescripcion;

    @NotNull (message = TransportProviderMessage.TP_ID_NOT_NULL)
    @Positive (message = Message.POSITIVE_INT)
    private Integer transportProviderId;
}
