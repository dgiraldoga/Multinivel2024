package co.banco.mio.bancomio.controller;


import co.banco.mio.bancomio.dto.ValidatorDTO;
import co.banco.mio.bancomio.dto.request.CreateValidadorRequest;
import co.banco.mio.bancomio.mapper.ValidatorMapper;
import co.banco.mio.bancomio.repository.ValidatorRepository;
import co.banco.mio.bancomio.service.ValidatorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/validator")
@CrossOrigin("*")
public class ValidatorController {

    private final ValidatorRepository validatorRepository;
    private final ValidatorService validatorService;

    public ValidatorController(ValidatorRepository validatorRepository, ValidatorService validatorService) {
        this.validatorRepository = validatorRepository;
        this.validatorService = validatorService;
    }


    @GetMapping(value = "/ping")
    public String pingPong() {
        return "pong";
    }

    @GetMapping(value = "/all")
    public List<ValidatorDTO> getValidators() {
        return ValidatorMapper.domainToDTOList(validatorRepository.findAll());
    }

    @PostMapping("/addvalidator")
    public ResponseEntity<ValidatorDTO> addValidator(@RequestBody @Valid CreateValidadorRequest request) throws Exception {
        return ResponseEntity.ok(validatorService.createValidator(request));
    }
}
