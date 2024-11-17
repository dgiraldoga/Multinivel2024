package co.banco.mio.bancomio.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardResponseApplication {
    private Integer serialCardNumber;;
    private Character cardStatus;
}
