package co.banco.mio.bancomio.service;

import co.banco.mio.bancomio.dto.CardUsageDTO;
import co.banco.mio.bancomio.dto.request.CreateCardUsageRequest;

public interface CardUsageService {

    CardUsageDTO addCardUsage(CreateCardUsageRequest request) throws Exception;

}
