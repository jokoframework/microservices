package io.github.jokoframework.microservice1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityDTO {

    private Long id;
    private String description;
    private String appId;

}
