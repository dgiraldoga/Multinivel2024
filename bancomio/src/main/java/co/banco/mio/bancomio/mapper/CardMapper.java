package co.banco.mio.bancomio.mapper;

import co.banco.mio.bancomio.domain.Card;
import co.banco.mio.bancomio.dto.CardDTO;

import java.time.LocalDateTime;
import java.util.List;

public class CardMapper {

    public CardDTO toDTO(Card card) {
        return CardDTO.builder()
                .serialCard(card.getSerialCard())
                .cardStatus(card.getCardSatus())
                .applicationId(card.getApplication() == null ? 700: card.getApplication().getAppId())
                .build();
    }

    public Card toEntity(CardDTO cardDTO) {

        return Card.builder()
                .serialCard(cardDTO.getSerialCard())
                .cardSatus(cardDTO.getCardStatus())
                .cardRegDate(LocalDateTime.now())
                .build();
    }


    public List<CardDTO> toDTOList(List<Card> cards) {
        return cards.stream().map(this::toDTO).toList();
    }

    public List<Card> toEntityList(List<CardDTO> cardDTOs) {
        return cardDTOs.stream().map(this::toEntity).toList();
    }
}
