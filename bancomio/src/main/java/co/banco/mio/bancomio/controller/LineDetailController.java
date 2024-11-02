package co.banco.mio.bancomio.controller;

import co.banco.mio.bancomio.dto.LineDetailDTO;
import co.banco.mio.bancomio.mapper.LineDetailMapper;
import co.banco.mio.bancomio.repository.LineDetailRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/line-detail")
public class LineDetailController {

    private final LineDetailRepository lineDetailRepository;

    public LineDetailController(LineDetailRepository lineDetailRepository) {
        this.lineDetailRepository = lineDetailRepository;
    }

    @GetMapping(value = "/ping")
    public String pingPong() {
        return "pong";
    }

    @GetMapping(value = "/all")
    public List<LineDetailDTO> getLineDetails() {
        /*List<TipoDocumentoDTO> tiposDocumentosDTO;
        List<TipoDocumento> tipoDocumentos = tipoDocumentoRepository.findAll();
        tiposDocumentosDTO = TipoDocumentoMapper.domainToDTOList(tipoDocumentos);
        return tiposDocumentosDTO;*/

        return LineDetailMapper.domainToDTOList(lineDetailRepository.findAll());
    }
}
