package co.banco.mio.bancomio.service;

import co.banco.mio.bancomio.dto.ApplicationDTO;
import co.banco.mio.bancomio.dto.request.CreateApplicationRequest;
import co.banco.mio.bancomio.dto.response.ApplicationResponseCard;

import java.util.List;


public interface ApplicationService {
    ApplicationDTO createApplication(CreateApplicationRequest request) throws Exception;

    ApplicationResponseCard getApplicationCard(int appId) throws Exception;

    ApplicationDTO getApplication(int appId) throws Exception;

    List<ApplicationDTO> getApplicationStatus (char status) throws Exception;

}
