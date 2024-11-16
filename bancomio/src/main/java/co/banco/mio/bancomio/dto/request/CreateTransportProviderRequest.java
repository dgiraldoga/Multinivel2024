package co.banco.mio.bancomio.dto.request;


import co.banco.mio.bancomio.utils.Message;
import co.banco.mio.bancomio.utils.TransportProviderMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateTransportProviderRequest {

    @NotBlank (message = Message.DESCRIPTION_NOT_NULL)
    @Size(min = 1, max = 100, message = TransportProviderMessage.SIZE_TRANSPORT_PROVIDER_NAME)
    private String tpDescription;

}
