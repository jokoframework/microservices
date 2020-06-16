package io.github.jokoframework.microservice2.controller;

import io.github.jokoframework.microservice2.dto.CountryDTO;
import io.github.jokoframework.microservice2.dto.ListResponseDTO;
import io.github.jokoframework.microservice2.service.Microservice2Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping(value="/v1/countries")
public class Microservice2Controller {

    private static final Logger LOG = LoggerFactory.getLogger(Microservice2Controller.class);

    private Microservice2Service service;

    @Value("${app.id}")
    private String instanceId;

    public Microservice2Controller(Microservice2Service service){
        this.service= service;
    }

    @GetMapping("/{id}")
    public CountryDTO getCountryById(@PathVariable("id") Long id) {
        LOG.info("Access to microservice 1 with app id {}", instanceId);
        return service.getById(id);
    }

    @GetMapping("/{id}/cities")
    public ListResponseDTO getCitiesByCountryId(@PathVariable("id") Long id,
                                                HttpServletRequest request) {
        LOG.info("Access to microservices 2 with app id {}", instanceId);
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        return service.getByCountryId(id, authorizationHeader);
    }


}
