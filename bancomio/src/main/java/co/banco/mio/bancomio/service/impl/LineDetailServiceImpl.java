package co.banco.mio.bancomio.service.impl;

import co.banco.mio.bancomio.domain.LineDetail;
import co.banco.mio.bancomio.dto.LineDetailDTO;
import co.banco.mio.bancomio.dto.request.CreateLineDetailsRequest;
import co.banco.mio.bancomio.mapper.LineDetailMapper;
import co.banco.mio.bancomio.repository.LineDetailRepository;
import co.banco.mio.bancomio.service.LineDetailService;
import co.banco.mio.bancomio.utils.Message;
import org.springframework.stereotype.Service;

@Service
public class LineDetailServiceImpl implements LineDetailService {

    private final LineDetailRepository lineDetailRepository;

    public LineDetailServiceImpl(LineDetailRepository lineDetailRepository) {
        this.lineDetailRepository = lineDetailRepository;
    }

    @Override
    public LineDetailDTO create(CreateLineDetailsRequest request) throws Exception {
        if (request == null) {
            throw new Exception(Message.OBJECT_NULL);
        }

        LineDetail lineDetail = LineDetailMapper.CreateLineDetailRequesttoEntity(request);

        LineDetail saveLineDetail = lineDetailRepository.save(lineDetail);

        return LineDetailMapper.domainToDTO(saveLineDetail);
    }
}
