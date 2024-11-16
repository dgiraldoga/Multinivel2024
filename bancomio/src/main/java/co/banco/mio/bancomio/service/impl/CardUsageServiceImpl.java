package co.banco.mio.bancomio.service.impl;

import co.banco.mio.bancomio.domain.*;
import co.banco.mio.bancomio.dto.CardUsageDTO;
import co.banco.mio.bancomio.dto.request.CreateCardUsageRequest;
import co.banco.mio.bancomio.mapper.CardUsageMapper;
import co.banco.mio.bancomio.repository.*;
import co.banco.mio.bancomio.service.CardUsageService;
import co.banco.mio.bancomio.utils.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CardUsageServiceImpl implements CardUsageService {

    private final CardRepository cardRepository;
    private final LineDetailRepository lineDetailRepository;
    private final UserRepository userRepository;
    private final ValidatorRepository validatorRepository;
    private final CardUsageRepository cardUsageRepository;

    public CardUsageServiceImpl(CardRepository cardRepository, LineDetailRepository lineDetailRepository, UserRepository userRepository, ValidatorRepository validatorRepository, CardUsageRepository cardUsageRepository) {
        this.cardRepository = cardRepository;
        this.lineDetailRepository = lineDetailRepository;
        this.userRepository = userRepository;
        this.validatorRepository = validatorRepository;
        this.cardUsageRepository = cardUsageRepository;
    }

    @Override
    public CardUsageDTO addCardUsage(CreateCardUsageRequest request) throws Exception {

        if (request == null) {
            throw new Exception(Message.OBJECT_NULL);
        }

        if (request.getTypeUsage() != 1 || request.getTypeUsage() != 0) {
            throw new Exception(CardUsageMessage.TYPE_USAGE);
        }

        Card card = cardRepository.findById(request.getSerialCardNumber()).orElseThrow(() -> new Exception( String.format(CardMessage.NOT_FOUND_CARD_ID, request.getSerialCardNumber())));
        LineDetail lineDetail = lineDetailRepository.findById(request.getLineDetailId()).orElseThrow(() -> new Exception( String.format(LineDestailMessage.NOT_FOUND_LDID, request.getLineDetailId())));
        User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new Exception( String.format(UserMessage.NOT_FOUND_USER, request.getUserId())));
        Validator validator = validatorRepository.findById(request.getValidator_id()).orElseThrow(() -> new Exception( String.format(ValidatorMessage.NOT_FOUND_VALIDATOR, request.getValidator_id())));

        int farevalue = (request.getTypeUsage() == 0 ) ? 0 : Fare.fareValue(LocalDate.now().getYear());

        CardUsage cardUsage = CardUsageMapper.createCardUsageRequesttoEntity(request);

        cardUsage.setCard(card);
        cardUsage.setLineDetail(lineDetail);
        cardUsage.setUser(user);
        cardUsage.setValidator(validator);
        cardUsage.setFareValue(farevalue);

        cardUsage = cardUsageRepository.save(cardUsage);

        return CardUsageMapper.domainToDTO(cardUsage);



    }
}
