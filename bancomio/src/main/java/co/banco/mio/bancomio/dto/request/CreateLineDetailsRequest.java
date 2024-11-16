package co.banco.mio.bancomio.dto.request;


import co.banco.mio.bancomio.utils.LineDestailMessage;
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
public class CreateLineDetailsRequest {

    @NotBlank(message = LineDestailMessage.LD_DESC_NOT_NULL)
    @Size(min = 1, max =  100, message = LineDestailMessage.SIZE_LD_DESC)
    private String ld_desc;
}

