package co.banco.mio.bancomio.controller;
import co.banco.mio.bancomio.dto.ApplicationDTO;
import co.banco.mio.bancomio.dto.request.CreateApplicationRequest;
import co.banco.mio.bancomio.dto.request.UpdateApplicationRequest;
import co.banco.mio.bancomio.dto.response.ApplicationResponseCard;
import co.banco.mio.bancomio.mapper.ApplicationMapper;
import co.banco.mio.bancomio.repository.ApplicationRepository;
import co.banco.mio.bancomio.service.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/application")
@CrossOrigin("*")
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
    public ResponseEntity<ApplicationDTO> addApplication(@RequestBody @Valid CreateApplicationRequest createApplicationRequest) throws Exception {
        return ResponseEntity.ok(applicationService.createApplication(createApplicationRequest));
    }

    @GetMapping ("/appwithcard/{appId}")
    public ResponseEntity<ApplicationResponseCard> getApplicationCard(@PathVariable Integer appId) throws Exception {
        return ResponseEntity.ok(applicationService.getApplicationCard(appId));
    }

    @GetMapping ("/applicationid/{id}")
    public ApplicationDTO getApplication(@PathVariable Integer id) throws Exception {
        return applicationService.getApplication(id);
    }

    @GetMapping ("/statusapplications/{status}")
    public List<ApplicationDTO> getApplicationsByStatus(@PathVariable String status) throws Exception {
        return applicationService.getApplicationStatus(status);
    }

    @PutMapping ("/updateapp/{id}")
    public ApplicationDTO updateApplication(@PathVariable Integer id, @RequestBody @Valid UpdateApplicationRequest updateApplicationRequest) throws Exception {
        return applicationService.updateApplication(id, updateApplicationRequest);
    }

    @PutMapping ("/activateapp/{id}")
    public ApplicationDTO activateApplication(@PathVariable Integer id) throws Exception {
        return applicationService.activateApplication(id);
    }

    @PutMapping ("/deactivateapp/{id}")
    public ApplicationDTO deactivateApplication(@PathVariable Integer id) throws Exception {
        return applicationService.deactivateApplication(id);
    }

    @DeleteMapping ("/appdelete/{id}")
    public void deleteApplication(@PathVariable Integer id) throws Exception {
        applicationService.deleteApplication(id);
    }
}
