package co.banco.mio.bancomio.service.impl;

import co.banco.mio.bancomio.domain.Application;
import co.banco.mio.bancomio.dto.ApplicationDTO;
import co.banco.mio.bancomio.dto.request.CreateApplicationRequest;
import co.banco.mio.bancomio.mapper.ApplicationMapper;
import co.banco.mio.bancomio.repository.ApplicationRepository;
import co.banco.mio.bancomio.service.ApplicationService;
import co.banco.mio.bancomio.utils.Message;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public ApplicationDTO createApplication(CreateApplicationRequest request) throws Exception {

        // Valida que el objeto no sea nulo
        if(request == null){
            throw new Exception(Message.OBJECT_NULL.getMessage());
        }

        // Valida el numero de digitos del id asignado
        if ((int) Math.log10(request.getAppId()) + 1 != 3){
            throw new Exception(String.format(Message.SIZE_ID.getMessage(), 3));
        }


        // Valida el tamanio de la descripccion asignada
        if (request.getAppDescription().isEmpty() || request.getAppDescription().isBlank() || request.getAppDescription().length() > 255){
            throw new Exception(String.format(Message.SIZE_DESCRIPTION.getMessage(), 100));
        }

        Application application = ApplicationMapper.builder().build().createApplicationRequesttoEntity(request);

        application = applicationRepository.save(application);

        return ApplicationMapper.builder().build().toDTO(application);



    }
}
