package io.github.jokoframework.microservice1.controller;

import io.github.jokoframework.microservice1.dto.CityDTO;
import io.github.jokoframework.microservice1.dto.ListResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value="/v1/cities")
public class Microservice1Controller {

    private static final Logger LOG = LoggerFactory.getLogger(Microservice1Controller.class);

    @Value("${app.id}")
    private String instanceId;

    @GetMapping("/{id}")
    public CityDTO getCityById(@PathVariable("id")
                    Long cliendId) {
        LOG.info("Access to service example 1 with app id {}", instanceId);
        return CityDTO.builder()
                .id(cliendId)
                .description("Asuncion")
                .appId(instanceId)
                .build();
    }

    @GetMapping("/country/{countryId}")
    public ListResponseDTO getCitiesByCountryId(@PathVariable("countryId")
                                       Long countryId) {
        LOG.info("Access to service example 1 with app id {}", instanceId);
        List<CityDTO> cities = new ArrayList<>();
        cities.add(CityDTO.builder()
                .id(1L)
                .description("Asuncion")
                .appId(instanceId)
                .build());
        cities.add(CityDTO.builder()
                .id(2L)
                .description("Encarnacion")
                .appId(instanceId)
                .build());

        return ListResponseDTO
                .builder()
                .cities(cities)
                .build();

    }





}
