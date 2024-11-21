package co.banco.mio.bancomio.controller;

import co.banco.mio.bancomio.dto.LineDetailDTO;
import co.banco.mio.bancomio.dto.request.CreateLineDetailsRequest;
import co.banco.mio.bancomio.mapper.LineDetailMapper;
import co.banco.mio.bancomio.repository.LineDetailRepository;
import co.banco.mio.bancomio.service.LineDetailService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/line-detail")
@CrossOrigin("*")
public class LineDetailController {

    private final LineDetailRepository lineDetailRepository;
    private final LineDetailService lineDetailService;

    public LineDetailController(LineDetailRepository lineDetailRepository, LineDetailService lineDetailService) {
        this.lineDetailRepository = lineDetailRepository;
        this.lineDetailService = lineDetailService;
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

    @PostMapping("/addlinedetail")
    public ResponseEntity<LineDetailDTO> addLineDetail(@RequestBody @Valid CreateLineDetailsRequest request) throws Exception {
        return ResponseEntity.ok(lineDetailService.create(request));
    }
}
