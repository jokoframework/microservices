package io.github.jokoframework.microservice1.service.impl;

import io.github.jokoframework.microservice1.dto.CityDTO;
import io.github.jokoframework.microservice1.dto.ListResponseDTO;
import io.github.jokoframework.microservice1.service.Microservice1Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Microservice1ServiceImpl implements Microservice1Service {

    @Value("${app.id}")
    private String instanceId;

    @Override
    public CityDTO getById(Long id) {
        return CityDTO.builder()
                .id(id)
                .description("Asuncion")
                .appId(instanceId)
                .build();
    }

    @Override
    public ListResponseDTO getByCountryId(Long country) {
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
