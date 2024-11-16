package co.banco.mio.bancomio.dto.request;


import co.banco.mio.bancomio.utils.ApplicationMessage;
import co.banco.mio.bancomio.utils.CardMessage;
import co.banco.mio.bancomio.utils.Message;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateCardRequest {

    @Size( min = 10, max = 10, message = CardMessage.SIZE_CARD_ID)
    @Positive( message = Message.POSITIVE_INT )
    private Integer serialCard;

    @NotNull(message = ApplicationMessage.APP_ID_NOT_NULL)
    @Positive( message = Message.POSITIVE_INT )
    private Integer appId;
}

