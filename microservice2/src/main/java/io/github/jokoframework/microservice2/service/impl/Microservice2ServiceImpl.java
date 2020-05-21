package io.github.jokoframework.microservice2.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.github.jokoframework.microservice2.dto.CityDTO;
import io.github.jokoframework.microservice2.dto.CountryDTO;
import io.github.jokoframework.microservice2.dto.ListResponseDTO;
import io.github.jokoframework.microservice2.service.Microservice2Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static io.github.jokoframework.microservice2.constants.ServiceNames.MICROSERVICE1;

@Service
public class Microservice2ServiceImpl implements Microservice2Service {

    @Value("${app.id}")
    private String instanceId;

    private final RestTemplate restTemplate;

    public Microservice2ServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public CountryDTO getById(Long id){
        return CountryDTO.builder()
                .id(id)
                .description("Paraguay")
                .appId(instanceId)
                .build();
    }

    @Override
    @HystrixCommand(fallbackMethod = "getCitiesDefaultById")
    public ListResponseDTO getByCountryId(Long countryId, String authorizationHeader) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, authorizationHeader);
        HttpEntity entity = new HttpEntity(headers);
        URI url = new DefaultUriBuilderFactory().builder()
                .scheme("http")
                .host(MICROSERVICE1.code())
                .path(String.format("v1/cities/country/%d", countryId))
                .build();
        ResponseEntity<ListResponseDTO> cities = restTemplate.exchange(url, HttpMethod.GET, entity, ListResponseDTO.class);
        return cities.getBody();
}

    private ListResponseDTO getCitiesDefaultById(Long id, String authorizationHeader){
        ListResponseDTO citiesDefault = new ListResponseDTO();
        List<CityDTO> cities = new ArrayList<>();
        cities.add(new CityDTO(1L, "Default", instanceId));
        citiesDefault.setCities(cities);
        return citiesDefault;
    }

}
