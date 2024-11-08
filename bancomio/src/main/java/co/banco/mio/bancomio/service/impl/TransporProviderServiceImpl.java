package co.banco.mio.bancomio.service.impl;

import co.banco.mio.bancomio.domain.TransportProvider;
import co.banco.mio.bancomio.dto.TransportProviderDTO;
import co.banco.mio.bancomio.dto.request.CreateTransportProviderRequest;
import co.banco.mio.bancomio.mapper.TransportProviderMapper;
import co.banco.mio.bancomio.repository.TransportProviderRepository;
import co.banco.mio.bancomio.service.TransportProviderService;

public class TransporProviderServiceImpl implements TransportProviderService {
    private TransportProviderRepository transportProviderRepository;

    public TransporProviderServiceImpl(TransportProviderRepository transportProviderRepository) {
        this.transportProviderRepository = transportProviderRepository;
    }

    @Override
    public TransportProviderDTO createTransportProvider(CreateTransportProviderRequest createTransportProviderRequest) throws Exception {
        if (createTransportProviderRequest == null) {
            throw new Exception("El objeto requerido no puede ser nulo");
        }

        if (createTransportProviderRequest.getTpDescription().isEmpty() || createTransportProviderRequest.getTpDescription().isBlank() || createTransportProviderRequest.getTpDescription().length() > 255) {
            throw new Exception("El descripcion cumple con los criterios de longitud");
        }

        TransportProvider transportProvider = TransportProviderMapper.createTransportProvidertoEntity(createTransportProviderRequest);

        TransportProvider savedTransportProvider = transportProviderRepository.save(transportProvider);

        return TransportProviderMapper.domainToDTO(savedTransportProvider);
    }
}
