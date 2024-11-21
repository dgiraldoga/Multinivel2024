package co.banco.mio.bancomio.mapper;

import co.banco.mio.bancomio.domain.TransportProvider;
import co.banco.mio.bancomio.dto.TransportProviderDTO;
import co.banco.mio.bancomio.dto.request.CreateTransportProviderRequest;
import co.banco.mio.bancomio.utils.State;

import java.time.LocalDateTime;
import java.util.List;

public class TransportProviderMapper {

    public static TransportProviderDTO domainToDTO(TransportProvider transportProvider) {
        return TransportProviderDTO.builder()
                .tpId(transportProvider.getTpId())
                .tpDesc(transportProvider.getTpDesc())
                .tpStatus(transportProvider.getTpStatus())
                .build();
    }

    public static TransportProvider dTOToDomain(TransportProviderDTO transportProviderDTO) {
        return TransportProvider.builder()
                .tpId(transportProviderDTO.getTpId())
                .tpDesc(transportProviderDTO.getTpDesc())
                .tpStatus(transportProviderDTO.getTpStatus())
                .tpRepDate(LocalDateTime.now())
                .build();
    }

    public static List<TransportProviderDTO> domainToDTOList(List<TransportProvider> transportationProviders) {
        return transportationProviders.stream().map(TransportProviderMapper::domainToDTO).toList();
    }

    public static List<TransportProvider> dTOToDomainList(List<TransportProviderDTO> transportProvidersDTO) {
        return transportProvidersDTO.stream().map(TransportProviderMapper::dTOToDomain).toList();
    }

    public static TransportProvider createTransportProvidertoEntity(CreateTransportProviderRequest createTransportProviders) {
        return TransportProvider.builder()
                .tpDesc(createTransportProviders.getTpDescription())
                .tpStatus(State.ACTIVE.getValue().charAt(0))
                .tpRepDate(LocalDateTime.now())
                .build();
    }
}
