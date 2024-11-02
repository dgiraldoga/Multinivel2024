package co.banco.mio.bancomio.controller;

import co.banco.mio.bancomio.dto.CardDTO;
import co.banco.mio.bancomio.mapper.CardMapper;
import co.banco.mio.bancomio.repository.CardRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {

    private final CardRepository cardRepository;

    public CardController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @GetMapping(value = "/ping")
    public String pingPong() {
        return "pong";
    }

    @GetMapping(value = "/all")
    public List<CardDTO> getCards() {
        /*List<TipoDocumentoDTO> tiposDocumentosDTO;
        List<TipoDocumento> tipoDocumentos = tipoDocumentoRepository.findAll();
        tiposDocumentosDTO = TipoDocumentoMapper.domainToDTOList(tipoDocumentos);
        return tiposDocumentosDTO;*/

        return CardMapper.domainToDTOList(cardRepository.findAll());
    }
}
