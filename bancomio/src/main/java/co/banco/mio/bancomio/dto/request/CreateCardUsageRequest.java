package co.banco.mio.bancomio.dto.request;

import co.banco.mio.bancomio.utils.*;
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
public class CreateCardUsageRequest {

    @NotNull(message = CardMessage.CARD_ID_NOT_NULL)
    @Positive( message = Message.POSITIVE_INT )
    @Size( min = 10, max = 10, message = CardMessage.SIZE_CARD_ID)
    private Integer serialCardNumber;

    @NotNull (message = LineDestailMessage.LD_ID_NOT_NULL)
    @Positive( message = Message.POSITIVE_INT )
    private Integer lineDetailId;

    @NotNull (message = UserMessage.USER_ID_NOT_NULL)
    @Positive( message = Message.POSITIVE_INT )
    private Integer userId;

    @NotNull (message = ValidatorMessage.VL_ID_NOT_NULL)
    @Positive( message = Message.POSITIVE_INT )
    @Size(min = 4, max = 4, message = ValidatorMessage.SIZE_VALIDATOR_ID)
    private Integer validator_id;

    @Size(min = 1, max = 1, message = CardUsageMessage.SIZE_TYPE_USAGE)
    private Integer typeUsage;

}

