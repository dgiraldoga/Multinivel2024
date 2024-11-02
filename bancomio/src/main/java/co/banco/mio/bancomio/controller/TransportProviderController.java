package co.banco.mio.bancomio.controller;

import co.banco.mio.bancomio.dto.LineDetailDTO;
import co.banco.mio.bancomio.dto.TransportProviderDTO;
import co.banco.mio.bancomio.mapper.LineDetailMapper;
import co.banco.mio.bancomio.mapper.TransportProviderMapper;
import co.banco.mio.bancomio.repository.LineDetailRepository;
import co.banco.mio.bancomio.repository.TransportProviderRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transport-provider")
public class TransportProviderController {

    private final TransportProviderRepository transportProviderRepository;

    public TransportProviderController(TransportProviderRepository transportProviderRepository) {
        this.transportProviderRepository = transportProviderRepository;
    }

    @GetMapping(value = "/ping")
    public String pingPong() {
        return "pong";
    }

    @GetMapping(value = "/all")
    public List<TransportProviderDTO> getTransportProviders() {
        /*List<TipoDocumentoDTO> tiposDocumentosDTO;
        List<TipoDocumento> tipoDocumentos = tipoDocumentoRepository.findAll();
        tiposDocumentosDTO = TipoDocumentoMapper.domainToDTOList(tipoDocumentos);
        return tiposDocumentosDTO;*/

        return TransportProviderMapper.domainToDTOList(transportProviderRepository.findAll());
    }
}
