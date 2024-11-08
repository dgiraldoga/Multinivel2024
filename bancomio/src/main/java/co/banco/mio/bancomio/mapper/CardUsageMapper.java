package co.banco.mio.bancomio.mapper;

import co.banco.mio.bancomio.domain.CardUsage;
import co.banco.mio.bancomio.dto.CardUsageDTO;

import java.util.List;

public class CardUsageMapper {

    public static CardUsageDTO domainToDTO (CardUsage cardUsage){
        return CardUsageDTO.builder()
                .cardId(cardUsage.getCardId() == null?null: cardUsage.getCardId().getSerialCard())
                .lineDetailId(cardUsage.getLineDetailId() == null?null: cardUsage.getLineDetailId().getLdId())
                .userId(cardUsage.getUserId() == null?null: cardUsage.getUserId().getUserId())
                .validatorId(cardUsage.getValidatorId() == null?null: cardUsage.getValidatorId().getVlId())
                .cuDateTime(cardUsage.getCuDateTime())
                .fareValue(cardUsage.getFareValue())
                .typeUsage(cardUsage.getTypeUsage())
                .tsn(cardUsage.getTsn())
                .build();
    }

    public static CardUsage dTOToDomain (CardUsageDTO cardUsageDTO){
        return CardUsage.builder()
                .cuDateTime(cardUsageDTO.getCuDateTime())
                .fareValue(cardUsageDTO.getFareValue())
                .typeUsage(cardUsageDTO.getTypeUsage())
                .tsn(cardUsageDTO.getTsn())
                .build();
    }

    public static List<CardUsageDTO> domainToDTOList(List<CardUsage>cardUsages){
        return cardUsages.stream().map(CardUsageMapper::domainToDTO).toList();
    }

    public static  List<CardUsage> dTOToDomainList (List<CardUsageDTO> cardUsagesDTO){
        return  cardUsagesDTO.stream().map(CardUsageMapper::dTOToDomain).toList();
    }
}
