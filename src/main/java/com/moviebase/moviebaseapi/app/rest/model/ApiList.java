package com.moviebase.moviebaseapi.app.rest.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Set;

@ApiModel(value = "List", description = "List model")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiList implements IApiObject {

    @ApiModelProperty(notes = "Lists name")
    @NotNull(message = "Lists name must exist")
    private String name;

    @ApiModelProperty(notes = "Movies in list")
    private Set<ApiMovie> movies;

}
