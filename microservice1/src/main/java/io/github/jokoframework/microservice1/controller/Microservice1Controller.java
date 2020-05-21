package io.github.jokoframework.microservice1.controller;

import io.github.jokoframework.microservice1.dto.CityDTO;
import io.github.jokoframework.microservice1.dto.ListResponseDTO;
import io.github.jokoframework.microservice1.service.Microservice1Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/v1/cities")
public class Microservice1Controller {

    private static final Logger LOG = LoggerFactory.getLogger(Microservice1Controller.class);

    @Value("${app.id}")
    private String instanceId;

    private final Microservice1Service service;

    public Microservice1Controller(Microservice1Service service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public CityDTO getCityById(@PathVariable("id")
                    Long id) {
        LOG.info("Access to service example 1 with app id {}", instanceId);
        return service.getById(id);
    }

    @GetMapping("/country/{countryId}")
    public ListResponseDTO getCitiesByCountryId(@PathVariable("countryId")
                                       Long countryId) {
        LOG.info("Access to service example 1 with app id {}", instanceId);
        return service.getByCountryId(countryId);
    }





}
