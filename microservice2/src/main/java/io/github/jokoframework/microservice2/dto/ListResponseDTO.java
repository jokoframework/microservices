package io.github.jokoframework.microservice2.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class ListResponseDTO {
    private List<CityDTO> cities;
}
