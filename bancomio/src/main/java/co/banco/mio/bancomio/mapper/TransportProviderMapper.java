package co.banco.mio.bancomio.mapper;

import co.banco.mio.bancomio.domain.TransportProvider;
import co.banco.mio.bancomio.dto.TransportProviderDTO;

import java.util.List;

public class TransportProviderMapper {

    public static TransportProviderDTO domainToDTO (TransportProvider transportProvider){
        return TransportProviderDTO.builder()
                .tpId(transportProvider.getTpId())
                .tpDesc(transportProvider.getTpDesc())
                .tpStatus(transportProvider.getTpStatus())
                .tpRepDate(transportProvider.getTpRepDate())
                .build();
    }

    public static TransportProvider dTOToDomain (TransportProviderDTO transportProviderDTO){
        return TransportProvider.builder()
                .tpId(transportProviderDTO.getTpId())
                .tpDesc(transportProviderDTO.getTpDesc())
                .tpStatus(transportProviderDTO.getTpStatus())
                .tpRepDate(transportProviderDTO.getTpRepDate())
                .build();
    }

    public static List<TransportProviderDTO> domainToDTOList(List<TransportProvider>transportationProviders){
        return transportationProviders.stream().map(TransportProviderMapper::domainToDTO).toList();
    }

    public static  List<TransportProvider> dTOToDomainList (List<TransportProviderDTO> transportProvidersDTO){
        return  transportProvidersDTO.stream().map(TransportProviderMapper::dTOToDomain).toList();
    }
}
