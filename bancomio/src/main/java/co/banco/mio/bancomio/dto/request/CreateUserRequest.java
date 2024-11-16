package co.banco.mio.bancomio.dto.request;


import co.banco.mio.bancomio.utils.UserMessage;
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
public class CreateUserRequest {

    @NotBlank (message = UserMessage.NAME_NOT_NULL)
    @Size(min = 1, max = 100, message = UserMessage.SIZE_NAME)
    private String name;

    @NotBlank (message = UserMessage.LAST_NAME_NOT_NULL)
    @Size(min = 1, max = 100, message = UserMessage.SIZE_LASTNAME)
    private String lastName;

    @NotBlank (message = UserMessage.CITY_NOT_NULL)
    @Size(min = 1, max = 100, message = UserMessage.SIZE_CITY)
    private String city;

}
