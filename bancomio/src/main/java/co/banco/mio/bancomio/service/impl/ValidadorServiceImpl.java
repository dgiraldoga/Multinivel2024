package co.banco.mio.bancomio.service.impl;

import co.banco.mio.bancomio.domain.TransportProvider;
import co.banco.mio.bancomio.domain.Validator;
import co.banco.mio.bancomio.dto.ValidatorDTO;
import co.banco.mio.bancomio.dto.request.CreateValidadorRequest;
import co.banco.mio.bancomio.mapper.ValidatorMapper;
import co.banco.mio.bancomio.repository.TransportProviderRepository;
import co.banco.mio.bancomio.repository.ValidatorRepository;
import co.banco.mio.bancomio.service.ValidatorService;
import co.banco.mio.bancomio.utils.Message;
import co.banco.mio.bancomio.utils.TransportProviderMessage;
import org.springframework.stereotype.Service;

@Service
public class ValidadorServiceImpl implements ValidatorService {

    private final TransportProviderRepository transportProviderRepository;
    private final ValidatorRepository validatorRepository;

    public ValidadorServiceImpl(TransportProviderRepository transportProviderRepository, ValidatorRepository validatorRepository) {
        this.transportProviderRepository = transportProviderRepository;
        this.validatorRepository = validatorRepository;
    }

    @Override
    public ValidatorDTO createValidator(CreateValidadorRequest request) throws Exception {

        if (request == null) {
            throw new Exception(Message.OBJECT_NULL);
        }


        TransportProvider transportProvider = transportProviderRepository.findById(request.getVlId()).orElse(null);

        if (transportProvider == null) {
            throw new Exception(String.format(TransportProviderMessage.NOT_FOUND_TRANSPORTPROVIDER, request.getVlId()));
        }

        Validator validator = ValidatorMapper.createValidatorRequesttoEntity(request);
        validator.setTransportProvider(transportProvider);

        validator = validatorRepository.save(validator);

        return ValidatorMapper.domainToDTO(validator);


    }
}
