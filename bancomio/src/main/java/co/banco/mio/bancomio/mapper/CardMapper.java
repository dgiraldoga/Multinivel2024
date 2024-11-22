package co.banco.mio.bancomio.mapper;

import co.banco.mio.bancomio.domain.Application;
import co.banco.mio.bancomio.domain.Card;
import co.banco.mio.bancomio.dto.CardDTO;
import co.banco.mio.bancomio.dto.request.CreateCardRequest;
import co.banco.mio.bancomio.dto.response.CardResponseApplication;
import co.banco.mio.bancomio.repository.ApplicationRepository;
import co.banco.mio.bancomio.service.impl.ApplicationServiceImpl;
import co.banco.mio.bancomio.utils.CardMessage;
import co.banco.mio.bancomio.utils.State;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public class CardMapper {

    public CardDTO toDTO(Card card) {
        return CardDTO.builder()
                .serialCard(card.getSerialCard())
                .cardStatus(card.getCardStatus())
                .applicationId(card.getApplication() == null ? 700: card.getApplication().getAppId())
                .build();
    }

    public Card toEntity(CardDTO cardDTO) {

        return Card.builder()
                .serialCard(cardDTO.getSerialCard())
                .cardStatus(cardDTO.getCardStatus())
                .cardRegDate(LocalDateTime.now())
                .build();
    }


    public List<CardDTO> toDTOList(List<Card> cards) {
        return cards.stream().map(this::toDTO).toList();
    }

    public List<Card> toEntityList(List<CardDTO> cardDTOs) {
        return cardDTOs.stream().map(this::toEntity).toList();
    }

    public static Card createCardRequesttoEntity (CreateCardRequest createCardRequest) {
        return Card.builder()
                .serialCard(createCardRequest.getSerialCard())
                .cardStatus(State.ACTIVE.getValue().charAt(0))
                .cardRegDate(LocalDateTime.now())
                .build();
    }


    public CardResponseApplication cardResponseApplication(Card card) {
        return CardResponseApplication.builder()
                .serialCardNumber(card.getSerialCard())
                .cardStatus(card.getCardStatus())
                .build();
    }

    public List<CardResponseApplication> cardResponseApplicationList(List<Card> cards) {
        return cards.stream().map(this::cardResponseApplication).toList();
    }
}
