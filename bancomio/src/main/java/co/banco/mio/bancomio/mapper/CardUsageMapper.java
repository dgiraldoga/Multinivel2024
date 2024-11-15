package co.banco.mio.bancomio.mapper;

import co.banco.mio.bancomio.domain.CardUsage;
import co.banco.mio.bancomio.dto.CardUsageDTO;
import co.banco.mio.bancomio.dto.request.CreateCardUsageRequest;

import java.time.LocalDateTime;
import java.util.List;

public class CardUsageMapper {

    public static CardUsageDTO domainToDTO (CardUsage cardUsage){
        return CardUsageDTO.builder()
                .cardId(cardUsage.getId() == null?null: cardUsage.getCard().getSerialCard())
                .lineDetailId(cardUsage.getLineDetail() == null?null: cardUsage.getLineDetail().getLdId())
                .userId(cardUsage.getUser() == null?null: cardUsage.getUser().getUserId())
                .validatorId(cardUsage.getValidator() == null?null: cardUsage.getValidator().getVlId())
                .cuDateTime(cardUsage.getCuDateTime())
                .fareValue(cardUsage.getFareValue())
                .typeUsage(cardUsage.getTypeUsage())
                .build();
    }

    public static CardUsage dTOToDomain (CardUsageDTO cardUsageDTO){
        return CardUsage.builder()
                .cuDateTime(cardUsageDTO.getCuDateTime())
                .fareValue(cardUsageDTO.getFareValue())
                .typeUsage(cardUsageDTO.getTypeUsage())
                .build();
    }

    public static List<CardUsageDTO> domainToDTOList(List<CardUsage>cardUsages){
        return cardUsages.stream().map(CardUsageMapper::domainToDTO).toList();
    }

    public static  List<CardUsage> dTOToDomainList (List<CardUsageDTO> cardUsagesDTO){
        return  cardUsagesDTO.stream().map(CardUsageMapper::dTOToDomain).toList();
    }

    public static CardUsage createCardUsageRequesttoEntity(CreateCardUsageRequest createCardUsageRequest){
        return CardUsage.builder()
                .cuDateTime(LocalDateTime.now())
                .typeUsage(createCardUsageRequest.getTypeUsage())
                .build();

    }
}
