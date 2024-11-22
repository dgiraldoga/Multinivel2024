package co.banco.mio.bancomio.service.impl;

import co.banco.mio.bancomio.domain.Application;
import co.banco.mio.bancomio.domain.Card;
import co.banco.mio.bancomio.dto.CardDTO;
import co.banco.mio.bancomio.dto.request.CreateCardRequest;
import co.banco.mio.bancomio.mapper.CardMapper;
import co.banco.mio.bancomio.repository.ApplicationRepository;
import co.banco.mio.bancomio.repository.CardRepository;
import co.banco.mio.bancomio.service.CardService;
import co.banco.mio.bancomio.utils.ApplicationMessage;
import co.banco.mio.bancomio.utils.CardMessage;
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
            throw new Exception(Message.OBJECT_NULL);
        }

        if (!String.valueOf(request.getAppId()).startsWith("19")) {
            throw new Exception(CardMessage.PROYECT_ID);
        }

        Application application = applicationRepository.findById(request.getAppId()).orElseThrow(() -> new Exception(String.format(ApplicationMessage.NOT_FOUND_APP_ID, request.getAppId())));

        if (cardRepository.existsBySerialCardAndCardStatusAndApplication(request.getSerialCard(), State.ACTIVE.getValue().charAt(0), application)){
            throw new Exception(String.format(CardMessage.CARD_EXIST, request.getSerialCard()));
        }

        Card card = CardMapper.builder().build().createCardRequesttoEntity(request);

        card.setApplication(application);

        card = cardRepository.save(card);

        return CardMapper.builder().build().toDTO(card);


    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public CardDTO inactivateCard(Integer cardId) throws Exception {

        Card card = findById(cardId);

        if (card.getCardStatus().equals(State.DEACTIVE.getValue())) {
            throw new Exception(
                    String.format(
                            CardMessage.STATUS_CARD,
                            card.getSerialCard(), State.DEACTIVE.getValue()
                    )
            );
        }

        card.setCardStatus(State.DEACTIVE.getValue().charAt(0));
        card = cardRepository.save(card);
        return CardMapper.builder().build().toDTO(card);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public CardDTO activateCard(Integer cardId) throws Exception {
        Card card = findById(cardId);

        if (card.getCardStatus().equals(State.ACTIVE.getValue())) {
            throw new Exception(
                    String.format(
                            CardMessage.STATUS_CARD,
                            card.getSerialCard(), State.ACTIVE.getValue()
                    )
            );
        }

        card.setCardStatus(State.ACTIVE.getValue().charAt(0));
        card = cardRepository.save(card);
        return CardMapper.builder().build().toDTO(card);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteCard(Integer cardId) throws Exception {
        Card card = findById(cardId);
        cardRepository.delete(card);
    }


    @Transactional(readOnly = true)
    protected Card findById(Integer id) throws Exception {
        // Consultar la categoría y si no la encuentra, lanza excepcion
        return cardRepository.findById(id)
                .orElseThrow(
                        () -> new Exception(
                                String.format(CardMessage.NOT_FOUND_CARD_ID, id)
                        )
                );
    }
}
