package com.moviebase.moviebaseapi.app.rest.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@ApiModel(value = "Movie", description = "Movie model")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiMovie implements IApiObject {

    @ApiModelProperty(notes = "Movie name")
    private String name;
    @ApiModelProperty(notes = "Movie API key")
    private String apiKey;

}
