package co.banco.mio.bancomio.mapper;

import co.banco.mio.bancomio.domain.Application;
import co.banco.mio.bancomio.domain.Card;
import co.banco.mio.bancomio.dto.ApplicationDTO;
import co.banco.mio.bancomio.dto.request.CreateApplicationRequest;
import co.banco.mio.bancomio.dto.request.UpdateApplicationRequest;
import co.banco.mio.bancomio.dto.response.ApplicationResponseCard;
import co.banco.mio.bancomio.dto.response.CardResponseApplication;
import co.banco.mio.bancomio.utils.State;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

@Builder
public class ApplicationMapper {
	
	public ApplicationDTO toDTO(Application application) {
		return ApplicationDTO.builder()
				.appId(application.getAppId())
				.appDsc(application.getAppDsc())
				.appStatus(application.getAppStatus())
				.build();
	}

	public Application toEntity(ApplicationDTO applicationDTO) {
		return Application.builder()
				.appId(applicationDTO.getAppId())
				.appDsc(applicationDTO.getAppDsc())
				.appStatus(applicationDTO.getAppStatus())
				.build();
	}

	public List<ApplicationDTO> toDTOList(List<Application> applications) {
		return applications.stream().map(this::toDTO).toList();
	}

	public List<Application> toEntityList(List<ApplicationDTO> applicationDTOs) {
		return applicationDTOs.stream().map(this::toEntity).collect(Collectors.toList());
	}

	public Application createApplicationRequesttoEntity(CreateApplicationRequest createApplicationRequest) {
		return Application.builder()
				.appId(createApplicationRequest.getAppId())
				.appDsc(createApplicationRequest.getAppDescription().toUpperCase())
				.appStatus(State.ACTIVE.getValue().charAt(0))
				.build();
	}

	public ApplicationResponseCard toCardResponseApplication(Application application, List<CardResponseApplication> cardResponseApplications) {
		return ApplicationResponseCard.builder()
				.applicationId(application.getAppId())
				.applicationDescription(application.getAppDsc())
				.cards(cardResponseApplications)
				.build();
	}

	public Application updateApplicationRequesttoEntity(Application application, UpdateApplicationRequest updateApplicationRequest) {
		application.setAppStatus(State.ACTIVE.getValue().charAt(0));
		application.setAppDsc(updateApplicationRequest.getAppDescription().toUpperCase());
		return application;
	}




}

