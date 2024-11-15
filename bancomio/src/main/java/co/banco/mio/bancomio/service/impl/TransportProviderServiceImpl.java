package co.banco.mio.bancomio.service.impl;

import co.banco.mio.bancomio.domain.TransportProvider;
import co.banco.mio.bancomio.domain.Validator;
import co.banco.mio.bancomio.dto.TransportProviderDTO;
import co.banco.mio.bancomio.dto.request.CreateTransportProviderRequest;
import co.banco.mio.bancomio.mapper.TransportProviderMapper;
import co.banco.mio.bancomio.repository.TransportProviderRepository;
import co.banco.mio.bancomio.service.TransportProviderService;
import co.banco.mio.bancomio.utils.Message;
import org.springframework.transaction.annotation.Transactional;


public class TransportProviderServiceImpl implements TransportProviderService {
    private final TransportProviderRepository transportProviderRepository;

    public TransportProviderServiceImpl(TransportProviderRepository transportProviderRepository) {
        this.transportProviderRepository = transportProviderRepository;
    }

    @Override
    public TransportProviderDTO createTransportProvider(CreateTransportProviderRequest createTransportProviderRequest) throws Exception {
        if (createTransportProviderRequest == null) {
            throw new Exception(Message.OBJECT_NULL.getMessage());
        }

        if (createTransportProviderRequest.getTpDescription().isEmpty() || createTransportProviderRequest.getTpDescription().isBlank() || createTransportProviderRequest.getTpDescription().length() > 255) {
            throw new Exception(String.format(Message.SIZE_DESCRIPTION.getMessage(), 100));
        }

        TransportProvider transportProvider = TransportProviderMapper.createTransportProvidertoEntity(createTransportProviderRequest);

        TransportProvider savedTransportProvider = transportProviderRepository.save(transportProvider);

        return TransportProviderMapper.domainToDTO(savedTransportProvider);
    }

    @Override
    @Transactional
    public void eliminarTransportProvider(Integer transportPID) throws Exception {

        TransportProvider transportProvider = transportProviderRepository.findById(transportPID)
                .orElseThrow(() -> new IllegalArgumentException("El transpport provider con ID " + transportPID + " no existe."));

        if (transportProvider.getValidators() != null && !transportProvider.getValidators().isEmpty()) {
            // Opción: lanzar una excepción si tiene pedidos asociados
            // throw new IllegalArgumentException("El producto tiene pedidos asociados y no se puede eliminar.");

            // Opción: eliminar los pedidos manualmente
            transportProvider.getValidators().clear();
            transportProviderRepository.save(transportProvider);
        }

        transportProviderRepository.delete(transportProvider);
    }
}
