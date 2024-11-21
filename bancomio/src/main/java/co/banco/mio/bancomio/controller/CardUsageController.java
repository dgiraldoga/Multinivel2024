package co.banco.mio.bancomio.controller;

import co.banco.mio.bancomio.dto.CardUsageDTO;
import co.banco.mio.bancomio.dto.request.CreateCardUsageRequest;
import co.banco.mio.bancomio.mapper.CardUsageMapper;
import co.banco.mio.bancomio.repository.CardUsageRepository;
import co.banco.mio.bancomio.service.CardUsageService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card-usage")
@CrossOrigin("*")
public class CardUsageController {

    private final CardUsageRepository cardUsageRepository;
    private final CardUsageService cardUsageService;

    public CardUsageController(CardUsageRepository cardUsageRepository, CardUsageService cardUsageService) {
        this.cardUsageRepository = cardUsageRepository;
        this.cardUsageService = cardUsageService;
    }

    @GetMapping(value = "/ping")
    public String pingPong() {
        return "pong";
    }

    @GetMapping(value = "/all")
    public List<CardUsageDTO> getCardUsages() {
        return CardUsageMapper.domainToDTOList(cardUsageRepository.findAll());
    }

    @PostMapping("/addCardUsage")
    public ResponseEntity <CardUsageDTO> addCardUsage(@RequestBody @Valid CreateCardUsageRequest request) throws Exception {
        return ResponseEntity.ok(cardUsageService.addCardUsage(request));
    }


}
