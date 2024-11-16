package co.banco.mio.bancomio.controller;

import co.banco.mio.bancomio.dto.TransportProviderDTO;
import co.banco.mio.bancomio.dto.request.CreateTransportProviderRequest;
import co.banco.mio.bancomio.mapper.TransportProviderMapper;
import co.banco.mio.bancomio.repository.TransportProviderRepository;
import co.banco.mio.bancomio.service.TransportProviderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transport-provider")
public class TransportProviderController {

    private final TransportProviderRepository transportProviderRepository;
    private final TransportProviderService transportProviderService;

    public TransportProviderController(TransportProviderRepository transportProviderRepository, TransportProviderService transportProviderService) {
        this.transportProviderRepository = transportProviderRepository;
        this.transportProviderService = transportProviderService;
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

    @PostMapping ("/addtransportprovider")
    public ResponseEntity<TransportProviderDTO> addTransportProvider(@RequestBody @Valid CreateTransportProviderRequest createTransportProviderRequest) throws Exception {
        return ResponseEntity.ok(transportProviderService.createTransportProvider(createTransportProviderRequest));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> eliminarTransportProvider(@PathVariable Integer id) throws Exception {
        try {
            transportProviderService.eliminarTransportProvider(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Producto eliminado exitosamente.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El producto con ID " + id + " no existe.");
        }
    }
}
