package co.banco.mio.bancomio.mapper;

import co.banco.mio.bancomio.domain.LineDetail;
import co.banco.mio.bancomio.dto.LineDetailDTO;

import java.util.List;

public class LineDetailMapper {

    public static LineDetailDTO domainToDTO (LineDetail lineDetail){
        return LineDetailDTO.builder().
                ldId(lineDetail.getLdId())
                .ldDsc(lineDetail.getLdDsc())
                .ldStatus(lineDetail.getLdStatus())
                .ldRegDate(lineDetail.getLdRegDate())
                .build();
    }

    public static LineDetail dTOToDomain (LineDetailDTO lineDetailDTO){
        return LineDetail.builder()
                .ldId(lineDetailDTO.getLdId())
                .ldDsc(lineDetailDTO.getLdDsc())
                .ldStatus(lineDetailDTO.getLdStatus())
                .ldRegDate(lineDetailDTO.getLdRegDate())
                .build();
    }

    public static List<LineDetailDTO> domainToDTOList(List<LineDetail>lineDetails){
        return lineDetails.stream().map(LineDetailMapper::domainToDTO).toList();
    }

    public static  List<LineDetail> dTOToDomainList (List<LineDetailDTO> lineDetailsDTO){
        return  lineDetailsDTO.stream().map(LineDetailMapper::dTOToDomain).toList();
    }
}
