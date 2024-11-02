package co.banco.mio.bancomio.mapper;

import co.banco.mio.bancomio.domain.Application;
import co.banco.mio.bancomio.dto.ApplicationDTO;

import java.util.List;

public class ApplicationMapper {
	
	public static ApplicationDTO domainToDTO (Application application){
		return ApplicationDTO.builder()
				.appId(application.getAppId())
				.appDsc(application.getAppDsc())
				.appStatus(application.getAppStatus())
				.build();
	}

	public static Application dTOToDomain (ApplicationDTO applicationDTO){
		return Application.builder()
				.appId(applicationDTO.getAppId())
				.appDsc(applicationDTO.getAppDsc())
				.appStatus(applicationDTO.getAppStatus()).build();
	}

	public static List<ApplicationDTO> domainToDTOList(List<Application> applications){
		return applications.stream().map(ApplicationMapper::domainToDTO).toList();
	}

	public static  List<Application> dTOToDomainList (List<ApplicationDTO> aplicationsDTO){
		return  aplicationsDTO.stream().map(ApplicationMapper::dTOToDomain).toList();
	}

}
