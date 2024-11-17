package co.banco.mio.bancomio.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationResponseCard {

    private Integer applicationId;
    private String applicationDescription;
    List<CardResponseApplication> cards;

}
