package co.banco.mio.bancomio.controller;
import co.banco.mio.bancomio.dto.ApplicationDTO;
import co.banco.mio.bancomio.dto.request.CreateApplicationRequest;
import co.banco.mio.bancomio.mapper.ApplicationMapper;
import co.banco.mio.bancomio.repository.ApplicationRepository;
import co.banco.mio.bancomio.service.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/application")
public class ApplicationController {

    private final ApplicationRepository applicationRepository;
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationRepository applicationRepository, ApplicationService applicationService) {
        this.applicationRepository = applicationRepository;
        this.applicationService = applicationService;
    }

    @GetMapping(value = "/ping")
    public String pingPong() {
        return "pong";
    }

    @GetMapping(value = "/all")
    public List<ApplicationDTO> getApplications() {

        return ApplicationMapper.builder().build().toDTOList(applicationRepository.findAll());
    }

    @PostMapping("/addapplication")
    public ResponseEntity<ApplicationDTO> addApplication(@RequestBody CreateApplicationRequest createApplicationRequest) throws Exception {
        ApplicationDTO applicationDTO = applicationService.createApplication(createApplicationRequest);
        return ResponseEntity.ok(applicationDTO);
    }

}
