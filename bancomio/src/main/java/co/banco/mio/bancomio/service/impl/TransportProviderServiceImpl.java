package co.banco.mio.bancomio.service.impl;

import co.banco.mio.bancomio.domain.TransportProvider;
import co.banco.mio.bancomio.dto.TransportProviderDTO;
import co.banco.mio.bancomio.dto.request.CreateTransportProviderRequest;
import co.banco.mio.bancomio.mapper.TransportProviderMapper;
import co.banco.mio.bancomio.repository.TransportProviderRepository;
import co.banco.mio.bancomio.service.TransportProviderService;
import co.banco.mio.bancomio.utils.Message;


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
}
