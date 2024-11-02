package co.banco.mio.bancomio.mapper;

import co.banco.mio.bancomio.domain.Card;
import co.banco.mio.bancomio.dto.CardDTO;

import java.util.List;

public class CardMapper {

    public static CardDTO domainToDTO (Card card){
        return CardDTO.builder()
                .serialCard(card.getSerialCard())
                .cardRegDate(card.getCardRegDate())
                .cardSatus(card.getCardSatus())
                .aplicationId(card.getApplication() == null?null: card.getApplication().getAppId())
                .build();
    }

    public static Card dTOToDomain (CardDTO cardDTO){
        return Card.builder()
                .serialCard(cardDTO.getSerialCard())
                .cardRegDate(cardDTO.getCardRegDate())
                .cardSatus(cardDTO.getCardSatus())
                .build();
    }

    public static List<CardDTO> domainToDTOList(List<Card>cards){
        return cards.stream().map(CardMapper::domainToDTO).toList();
    }

    public static  List<Card> dTOToDomainList (List<CardDTO> cardsDTO){
        return  cardsDTO.stream().map(CardMapper::dTOToDomain).toList();
    }
}
