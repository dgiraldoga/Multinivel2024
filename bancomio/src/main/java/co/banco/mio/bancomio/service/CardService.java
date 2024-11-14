package co.banco.mio.bancomio.service;

import co.banco.mio.bancomio.dto.CardDTO;
import co.banco.mio.bancomio.dto.request.CreateCardRequest;

public interface CardService {

    CardDTO createCard(CreateCardRequest request) throws Exception;

    CardDTO inactivateCard(Integer cardId) throws Exception;

    CardDTO activateCard(Integer cardId) throws Exception;
}
