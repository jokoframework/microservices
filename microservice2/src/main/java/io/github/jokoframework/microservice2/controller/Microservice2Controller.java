package io.github.jokoframework.microservice2.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.github.jokoframework.microservice2.dto.CityDTO;
import io.github.jokoframework.microservice2.dto.CountryDTO;
import io.github.jokoframework.microservice2.dto.ListResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value="/v1/countries")
public class Microservice2Controller {

    private static final Logger LOG = LoggerFactory.getLogger(Microservice2Controller.class);

    private RestTemplate restTemplate;

    @Value("${app.id}")
    private String instanceId;

    public Microservice2Controller(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{id}")
    public CountryDTO getCountryById(@PathVariable("id")
                    Long id) {
        LOG.info("Access to microservice 1 with app id {}", instanceId);
        return CountryDTO.builder()
                .id(id)
                .description("Paraguay")
                .appId(instanceId)
                .build();
    }

    @GetMapping("/{id}/cities")
    @HystrixCommand(fallbackMethod = "getCitiesDefaultById")
    public ListResponseDTO getCitiesByCountryId(@PathVariable("id")
                                                      Long id) {
        LOG.info("Access to microservices 2 with app id {}", instanceId);
        ListResponseDTO cities = restTemplate.getForObject("http://microservice1/v1/cities/country/"+id, ListResponseDTO.class);
        return cities;
    }

    private ListResponseDTO getCitiesDefaultById(Long id){
        ListResponseDTO citiesDefault = new ListResponseDTO();
        List<CityDTO> cities = new ArrayList<>();
        cities.add(new CityDTO(1L, "Default", instanceId));
        citiesDefault.setCities(cities);
        return citiesDefault;
    }

}
