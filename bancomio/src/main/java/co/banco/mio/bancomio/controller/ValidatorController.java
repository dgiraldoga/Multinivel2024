package co.banco.mio.bancomio.controller;

import co.banco.mio.bancomio.dto.UserDTO;
import co.banco.mio.bancomio.dto.ValidatorDTO;
import co.banco.mio.bancomio.mapper.UserMapper;
import co.banco.mio.bancomio.mapper.ValidatorMapper;
import co.banco.mio.bancomio.repository.UserRepository;
import co.banco.mio.bancomio.repository.ValidatorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class ValidatorController {

    private final ValidatorRepository validatorRepository;

    public ValidatorController(ValidatorRepository validatorRepository) {
        this.validatorRepository = validatorRepository;
    }

    @GetMapping(value = "/ping")
    public String pingPong() {
        return "pong";
    }

    @GetMapping(value = "/all")
    public List<ValidatorDTO> getValidators() {
        /*List<TipoDocumentoDTO> tiposDocumentosDTO;
        List<TipoDocumento> tipoDocumentos = tipoDocumentoRepository.findAll();
        tiposDocumentosDTO = TipoDocumentoMapper.domainToDTOList(tipoDocumentos);
        return tiposDocumentosDTO;*/

        return ValidatorMapper.domainToDTOList(validatorRepository.findAll());
    }
}
