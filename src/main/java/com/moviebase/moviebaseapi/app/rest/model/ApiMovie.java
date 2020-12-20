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

    @ApiModelProperty(notes = "Movie title")
    private String title;
    @ApiModelProperty(notes = "Movie overview")
    private String overview;
    @ApiModelProperty(notes = "Movie API id")
    private Long apiId;

}
