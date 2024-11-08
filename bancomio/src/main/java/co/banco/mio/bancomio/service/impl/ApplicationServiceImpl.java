package co.banco.mio.bancomio.service.impl;

import co.banco.mio.bancomio.domain.Application;
import co.banco.mio.bancomio.dto.ApplicationDTO;
import co.banco.mio.bancomio.dto.request.CreateApplicationRequest;
import co.banco.mio.bancomio.mapper.ApplicationMapper;
import co.banco.mio.bancomio.repository.ApplicationRepository;
import co.banco.mio.bancomio.service.ApplicationService;
import org.springframework.context.ApplicationListener;

public class ApplicationServiceImpl implements ApplicationService {

    private ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public ApplicationDTO createApplication(CreateApplicationRequest request) throws Exception {

        // Valida que el objeto no sea nulo
        if(request == null){
            throw new Exception("El objeto requerido no puede ser nulo");
        }

        // Valida el numero de digitos del id asignado
        if ((int) Math.log10(request.getAppId()) + 1 > 3 || (int) Math.log10(request.getAppId()) + 1 < 3){
            throw new Exception("Id no cumple con el tamanio requerido ");
        }


        // Valida el tamanio de la descripccion asignada
        if (request.getAppDescription().isEmpty() || request.getAppDescription().isBlank() || request.getAppDescription().length() > 255){
            throw new Exception("El descripcion cumple con los criterios de longitud");
        }

        Application application = ApplicationMapper.builder().build().createApplicationRequesttoEntity(request);

        application = applicationRepository.save(application);

        return ApplicationMapper.builder().build().toDTO(application);



    }
}
