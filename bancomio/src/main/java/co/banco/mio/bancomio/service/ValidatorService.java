package co.banco.mio.bancomio.service;

import co.banco.mio.bancomio.dto.ValidatorDTO;
import co.banco.mio.bancomio.dto.request.CreateValidadorRequest;

public interface ValidatorService {

    ValidatorDTO createValidator(CreateValidadorRequest request) throws Exception;
}
