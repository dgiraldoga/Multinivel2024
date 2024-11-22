package co.banco.mio.bancomio.service.impl;

import co.banco.mio.bancomio.domain.Application;
import co.banco.mio.bancomio.domain.Card;
import co.banco.mio.bancomio.dto.ApplicationDTO;
import co.banco.mio.bancomio.dto.request.CreateApplicationRequest;
import co.banco.mio.bancomio.dto.request.UpdateApplicationRequest;
import co.banco.mio.bancomio.dto.response.ApplicationResponseCard;
import co.banco.mio.bancomio.mapper.ApplicationMapper;
import co.banco.mio.bancomio.mapper.CardMapper;
import co.banco.mio.bancomio.repository.ApplicationRepository;
import co.banco.mio.bancomio.repository.CardRepository;
import co.banco.mio.bancomio.service.ApplicationService;
import co.banco.mio.bancomio.utils.ApplicationMessage;
import co.banco.mio.bancomio.utils.Message;
import co.banco.mio.bancomio.utils.State;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final CardRepository cardRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository, CardRepository cardRepository) {
        this.applicationRepository = applicationRepository;
        this.cardRepository = cardRepository;
    }

    @Override
    @Transactional (rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public ApplicationDTO createApplication(CreateApplicationRequest request) throws Exception {

        if (request == null) {
            throw new Exception(Message.OBJECT_NULL);
        }

        if (applicationRepository.existsByAppIdOrAppDscAndAppStatus(request.getAppId(), request.getAppDescription(), State.ACTIVE.getValue().charAt(0))){
            throw new Exception(String.format(ApplicationMessage.APP_EXISTS, request.getAppId(), request.getAppDescription()));
        }

        Application application = ApplicationMapper.builder().build().createApplicationRequesttoEntity(request);

        application = applicationRepository.save(application);

        return ApplicationMapper.builder().build().toDTO(application);



    }

    @Override
    @Transactional (readOnly = true)
    public ApplicationResponseCard getApplicationCard(int appId) throws Exception {

        Application application = this.findApplicationById(appId);

        List <Card> cards = cardRepository.findCardByApplication(application);

        return ApplicationMapper.builder().build().toCardResponseApplication(application, CardMapper.builder().build().cardResponseApplicationList(cards));
    }

    @Override
    @Transactional (readOnly = true)
    public ApplicationDTO getApplication(int appId) throws Exception {

        Application application = this.findApplicationById(appId);

        return ApplicationMapper.builder().build().toDTO(application);
    }

    @Override
    @Transactional (readOnly = true)
    public List<ApplicationDTO> getApplicationStatus(String status) throws Exception {
         if  (!Arrays.asList(State.ACTIVE.getValue(), State.DEACTIVE.getValue()).contains(status)){
             throw new Exception(String.format(Message.STATUS_INCORRECT, status));
         }
         return ApplicationMapper.builder().build().toDTOList(applicationRepository.findByAppStatus(status.charAt(0)));
    }

    @Override
    @Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ApplicationDTO updateApplication(int appId, UpdateApplicationRequest request) throws Exception {

        Application application = this.findApplicationById(appId);

        if (request == null) {
            throw new Exception(Message.OBJECT_NULL);
        }

        if (applicationRepository.existsByAppDscAndAppStatus(request.getAppDescription(), State.ACTIVE.getValue().charAt(0))){
            throw new Exception();
        }

        application.setAppStatus(request.getStatus().charAt(0));
        application.setAppDsc(request.getAppDescription());

        return ApplicationMapper.builder().build().toDTO(applicationRepository.save(application));
    }

    @Override
    @Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ApplicationDTO activateApplication(int appId) throws Exception {
        Application application = this.findApplicationById(appId);
        application.setAppStatus(State.ACTIVE.getValue().charAt(0));
        return ApplicationMapper.builder().build().toDTO(applicationRepository.save(application));
    }

    @Override
    @Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ApplicationDTO deactivateApplication(int appId) throws Exception {
        Application application = this.findApplicationById(appId);
        application.setAppStatus(State.DEACTIVE.getValue().charAt(0));
        return ApplicationMapper.builder().build().toDTO(applicationRepository.save(application));
    }

    @Override
    @Transactional (propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteApplication(int appId) throws Exception {
        Application application = this.findApplicationById(appId);
        cardRepository.deleteCardByApplication(application);
        applicationRepository.delete(application);
    }


    private Application findApplicationById(int appId) throws Exception {
        return applicationRepository.findById(appId).orElseThrow(() -> new Exception(String.format(ApplicationMessage.NOT_FOUND_APP_ID, appId)));
    }


}
