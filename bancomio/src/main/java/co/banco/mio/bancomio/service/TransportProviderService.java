package co.banco.mio.bancomio.service;

import co.banco.mio.bancomio.dto.TransportProviderDTO;
import co.banco.mio.bancomio.dto.request.CreateTransportProviderRequest;

public interface TransportProviderService {
    TransportProviderDTO createTransportProvider(CreateTransportProviderRequest createTransportProviderRequest) throws Exception;

    public void eliminarTransportProvider(Integer transportPID) throws Exception;
}
