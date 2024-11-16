package co.banco.mio.bancomio.service.impl;

import co.banco.mio.bancomio.domain.TransportProvider;
import co.banco.mio.bancomio.domain.Validator;
import co.banco.mio.bancomio.dto.TransportProviderDTO;
import co.banco.mio.bancomio.dto.request.CreateTransportProviderRequest;
import co.banco.mio.bancomio.mapper.TransportProviderMapper;
import co.banco.mio.bancomio.repository.TransportProviderRepository;
import co.banco.mio.bancomio.service.TransportProviderService;
import co.banco.mio.bancomio.utils.Message;
import co.banco.mio.bancomio.utils.TransportProviderMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransportProviderServiceImpl implements TransportProviderService {
    private final TransportProviderRepository transportProviderRepository;

    public TransportProviderServiceImpl(TransportProviderRepository transportProviderRepository) {
        this.transportProviderRepository = transportProviderRepository;
    }

    @Override
    public TransportProviderDTO createTransportProvider(CreateTransportProviderRequest createTransportProviderRequest) throws Exception {
        if (createTransportProviderRequest == null) {
            throw new Exception(Message.OBJECT_NULL);
        }

        TransportProvider transportProvider = TransportProviderMapper.createTransportProvidertoEntity(createTransportProviderRequest);

        TransportProvider savedTransportProvider = transportProviderRepository.save(transportProvider);

        return TransportProviderMapper.domainToDTO(savedTransportProvider);
    }

    @Override
    @Transactional
    public void eliminarTransportProvider(Integer transportPID) throws Exception {

        TransportProvider transportProvider = transportProviderRepository.findById(transportPID)
                .orElseThrow(() -> new IllegalArgumentException(String.format(TransportProviderMessage.NOT_FOUND_TRANSPORTPROVIDER, transportPID)));

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
