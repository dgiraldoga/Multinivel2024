package co.banco.mio.bancomio.controller;

import co.banco.mio.bancomio.dto.CardDTO;
import co.banco.mio.bancomio.dto.CardUsageDTO;
import co.banco.mio.bancomio.mapper.CardMapper;
import co.banco.mio.bancomio.mapper.CardUsageMapper;
import co.banco.mio.bancomio.repository.CardRepository;
import co.banco.mio.bancomio.repository.CardUsageRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/card-usage")
public class CardUsageController {

    private final CardUsageRepository cardUsageRepository;

    public CardUsageController(CardUsageRepository cardUsageRepository) {
        this.cardUsageRepository = cardUsageRepository;
    }

    @GetMapping(value = "/ping")
    public String pingPong() {
        return "pong";
    }

    @GetMapping(value = "/all")
    public List<CardUsageDTO> getCardUsages() {
        /*List<TipoDocumentoDTO> tiposDocumentosDTO;
        List<TipoDocumento> tipoDocumentos = tipoDocumentoRepository.findAll();
        tiposDocumentosDTO = TipoDocumentoMapper.domainToDTOList(tipoDocumentos);
        return tiposDocumentosDTO;*/

        return CardUsageMapper.domainToDTOList(cardUsageRepository.findAll());
    }
}
