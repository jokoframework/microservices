package io.github.jokoframework.microservice1.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ListResponseDTO {
    private List<CityDTO> cities;
}
