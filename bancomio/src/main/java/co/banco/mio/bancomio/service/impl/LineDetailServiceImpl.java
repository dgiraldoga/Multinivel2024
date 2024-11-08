package co.banco.mio.bancomio.service.impl;

import co.banco.mio.bancomio.domain.LineDetail;
import co.banco.mio.bancomio.domain.TransportProvider;
import co.banco.mio.bancomio.dto.LineDetailDTO;
import co.banco.mio.bancomio.dto.request.CreateLineDetailsRequest;
import co.banco.mio.bancomio.mapper.LineDetailMapper;
import co.banco.mio.bancomio.mapper.TransportProviderMapper;
import co.banco.mio.bancomio.repository.LineDetailRepository;
import co.banco.mio.bancomio.service.LineDetailService;

public class LineDetailServiceImpl implements LineDetailService {

    private LineDetailRepository lineDetailRepository;

    public LineDetailServiceImpl(LineDetailRepository lineDetailRepository) {
        this.lineDetailRepository = lineDetailRepository;
    }

    @Override
    public LineDetailDTO create(CreateLineDetailsRequest request) throws Exception {
        if (request == null) {
            throw new Exception("El objeto requerido no puede ser nulo");
        }

        if(request.getLd_desc().isEmpty() || request.getLd_desc().isBlank() || request.getLd_desc().length()>255) {
            throw new Exception("la descripcion no puede ser mayor que 255");
        }

        LineDetail lineDetail = LineDetailMapper.CreateLineDetailRequesttoEntity(request);

        LineDetail saveLineDetail = lineDetailRepository.save(lineDetail);

        return LineDetailMapper.domainToDTO(saveLineDetail);
    }
}
