package io.github.jokoframework.microservice2.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CountryDTO {
    private Long id;
    private String description;
    private String appId;

}
