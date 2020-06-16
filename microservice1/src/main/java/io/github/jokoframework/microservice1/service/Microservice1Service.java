package io.github.jokoframework.microservice1.service;

import io.github.jokoframework.microservice1.dto.CityDTO;
import io.github.jokoframework.microservice1.dto.ListResponseDTO;

public interface  Microservice1Service {
    CityDTO getById(Long id);
    ListResponseDTO getByCountryId(Long country);
}
