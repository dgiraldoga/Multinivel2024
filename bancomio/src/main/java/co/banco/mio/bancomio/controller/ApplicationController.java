package co.banco.mio.bancomio.controller;
import co.banco.mio.bancomio.dto.ApplicationDTO;
import co.banco.mio.bancomio.mapper.ApplicationMapper;
import co.banco.mio.bancomio.repository.ApplicationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/application")
public class ApplicationController {

    private final ApplicationRepository applicationRepository;

    public ApplicationController(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }


    @GetMapping(value = "/ping")
    public String pingPong() {
        return "pong";
    }

    @GetMapping(value = "/all")
    public List<ApplicationDTO> getApplications() {

        return ApplicationMapper.builder().build().toDTOList(applicationRepository.findAll());
    }
}
