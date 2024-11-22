package co.banco.mio.bancomio.dto.request;



import co.banco.mio.bancomio.domain.Card;
import co.banco.mio.bancomio.utils.ApplicationMessage;
import co.banco.mio.bancomio.utils.CardMessage;
import co.banco.mio.bancomio.utils.Message;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateCardRequest {


    @Positive( message = Message.POSITIVE_INT )
    @Digits( integer = 10, fraction = 0, message = CardMessage.SIZE_CARD_ID)
    @JsonProperty ("serial_card")
    private Integer serialCard;


    @NotNull(message = ApplicationMessage.APP_ID_NOT_NULL)
    @JsonProperty ("application_id")
    private Integer appId;
}

