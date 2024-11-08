package co.banco.mio.bancomio.mapper;

import co.banco.mio.bancomio.domain.Validator;
import co.banco.mio.bancomio.dto.ValidatorDTO;

import java.time.LocalDateTime;
import java.util.List;

public class ValidatorMapper {

    public static ValidatorDTO domainToDTO (Validator validator){
        return ValidatorDTO.builder()
                .vlId(validator.getVlId())
                .vlDesc(validator.getVlDesc())
                .vlStatus(validator.getVlStatus())
                .transportProviderId(validator.getTransportProvider() == null?null: validator.getTransportProvider().getTpId())
                .build();
    }

    public static Validator dTOToDomain (ValidatorDTO validatorDTO){
        return Validator.builder()
                .vlId(validatorDTO.getVlId())
                .vlDesc(validatorDTO.getVlDesc())
                .vlStatus(validatorDTO.getVlStatus())
                .vlRegDate(LocalDateTime.now())
                .build();
    }

    public static List<ValidatorDTO> domainToDTOList(List<Validator>cards){
        return cards.stream().map(ValidatorMapper::domainToDTO).toList();
    }

    public static  List<Validator> dTOToDomainList (List<ValidatorDTO> cardsDTO){
        return  cardsDTO.stream().map(ValidatorMapper::dTOToDomain).toList();
    }
}
