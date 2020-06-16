package io.github.jokoframework.microservice2.service;

import io.github.jokoframework.microservice2.dto.CountryDTO;
import io.github.jokoframework.microservice2.dto.ListResponseDTO;

public interface Microservice2Service {
    CountryDTO getById(Long id);
    ListResponseDTO getByCountryId(Long countryId, String authorizationHeader);
}
