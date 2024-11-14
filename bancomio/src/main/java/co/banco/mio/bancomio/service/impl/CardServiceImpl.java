package co.banco.mio.bancomio.service.impl;

import co.banco.mio.bancomio.domain.Application;
import co.banco.mio.bancomio.domain.Card;
import co.banco.mio.bancomio.dto.CardDTO;
import co.banco.mio.bancomio.dto.request.CreateCardRequest;
import co.banco.mio.bancomio.mapper.CardMapper;
import co.banco.mio.bancomio.repository.ApplicationRepository;
import co.banco.mio.bancomio.repository.CardRepository;
import co.banco.mio.bancomio.service.CardService;
import co.banco.mio.bancomio.utils.Message;
import co.banco.mio.bancomio.utils.State;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CardServiceImpl implements CardService {

    private final ApplicationRepository applicationRepository;
    private final CardRepository cardRepository;

    public CardServiceImpl(ApplicationRepository applicationRepository, CardRepository cardRepository) {
        this.applicationRepository = applicationRepository;
        this.cardRepository = cardRepository;
    }

    @Override
    public CardDTO createCard(CreateCardRequest request) throws Exception {


        if (request == null) {
            throw new Exception(Message.OBJECT_NULL.getMessage());
        }

        if (!String.valueOf(request.getAppId()).startsWith("19")) {
            throw new Exception(Message.PROYECT_ID.getMessage());
        } else if (String.valueOf(request.getAppId()).length() != 10) {
            throw new Exception(String.format(Message.SIZE_ID.getMessage(), 10));
        }

        Application application = applicationRepository.findById(request.getAppId()).orElse(null);

        if (application == null) {
            throw new Exception(String.format(Message.DEPENDENT_ID.getMessage(), request.getAppId()));
        }

        Card card = CardMapper.builder().build().createCardRequesttoEntity(request);

        card.setApplication(application);

        card = cardRepository.save(card);

        return CardMapper.builder().build().toDTO(card);


    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public CardDTO inactivateCard(Integer cardId) throws Exception {

        Card card = findById(cardId);

        if (card.getCardStatus().equals(State.INACTIVE)) {
            throw new Exception(
                    String.format(
                            Message.TARJETA_EN_ESTADO.getMessage(),
                            card.getSerialCard(), State.INACTIVE.getValue()
                    )
            );
        }

        card.setCardStatus(State.INACTIVE.getValue());
        card = cardRepository.save(card);
        return CardMapper.builder().build().toDTO(card);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public CardDTO activateCard(Integer cardId) throws Exception {
        Card card = findById(cardId);

        if (card.getCardStatus().equals(State.ACTIVE)) {
            throw new Exception(
                    String.format(
                            Message.TARJETA_EN_ESTADO.getMessage(),
                            card.getSerialCard(), State.ACTIVE.getValue()
                    )
            );
        }

        card.setCardStatus(State.ACTIVE.getValue());
        card = cardRepository.save(card);
        return CardMapper.builder().build().toDTO(card);
    }

    @Transactional(readOnly = true)
    protected Card findById(Integer id) throws Exception {
        // Consultar la categoría y si no la encuentra, lanza excepcion
        return cardRepository.findById(id)
                .orElseThrow(
                        () -> new Exception(
                                String.format(Message.NO_EXISTE_TARJETA_X_ID.getMessage(), id)
                        )
                );
    }
}
