package co.banco.mio.bancomio.controller;

import co.banco.mio.bancomio.domain.Card;
import co.banco.mio.bancomio.dto.CardDTO;
import co.banco.mio.bancomio.dto.request.CreateCardRequest;
import co.banco.mio.bancomio.mapper.CardMapper;
import co.banco.mio.bancomio.repository.CardRepository;
import co.banco.mio.bancomio.service.CardService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {

    private final CardRepository cardRepository;
    private final CardService cardService;

    public CardController(CardRepository cardRepository, CardService cardService) {
        this.cardRepository = cardRepository;
        this.cardService = cardService;
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

        return CardMapper.builder().build().toDTOList(cardRepository.findAll());
    }

    @PostMapping("/addproduct")
    public ResponseEntity<CardDTO> addCard(@RequestBody CreateCardRequest request) throws Exception {
        CardDTO card = cardService.createCard(request);
        return ResponseEntity.ok(card);
    }
}
