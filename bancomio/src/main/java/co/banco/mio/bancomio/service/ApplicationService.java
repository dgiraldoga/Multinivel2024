package co.banco.mio.bancomio.service;

import co.banco.mio.bancomio.dto.ApplicationDTO;
import co.banco.mio.bancomio.dto.request.CreateApplicationRequest;

public interface ApplicationService {
    ApplicationDTO createApplication(CreateApplicationRequest request) throws Exception;
}
