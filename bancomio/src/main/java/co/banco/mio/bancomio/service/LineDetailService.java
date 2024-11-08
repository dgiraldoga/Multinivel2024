package co.banco.mio.bancomio.service;

import co.banco.mio.bancomio.dto.LineDetailDTO;
import co.banco.mio.bancomio.dto.request.CreateLineDetailsRequest;

public interface LineDetailService {

    LineDetailDTO create(CreateLineDetailsRequest request) throws Exception;
}
