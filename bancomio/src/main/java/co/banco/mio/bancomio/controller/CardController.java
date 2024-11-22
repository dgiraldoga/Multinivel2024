package co.banco.mio.bancomio.controller;

import co.banco.mio.bancomio.dto.CardDTO;
import co.banco.mio.bancomio.dto.request.CreateCardRequest;
import co.banco.mio.bancomio.mapper.CardMapper;
import co.banco.mio.bancomio.repository.CardRepository;
import co.banco.mio.bancomio.service.CardService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
@CrossOrigin("*")
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
    public ResponseEntity<CardDTO> addCard(@RequestBody @Valid CreateCardRequest request) throws Exception {
        return ResponseEntity.ok(cardService.createCard(request));
    }

    @PutMapping("/inactivate/{id}")
    public ResponseEntity<CardDTO> inactivateCard(@PathVariable Integer id) throws Exception{
        CardDTO cardDTO = cardService.inactivateCard(id);
        return ResponseEntity.ok(cardDTO);
    }

    @PutMapping("/activate/{id}")
    public ResponseEntity<CardDTO> activateCard(@PathVariable Integer id) throws Exception{
        CardDTO cardDTO = cardService.activateCard(id);
        return ResponseEntity.ok(cardDTO);
    }

    @DeleteMapping("/deletecard/{id}")
    public void deleteCard(@PathVariable Integer id) throws Exception{
        cardService.deleteCard(id);
    }
}
