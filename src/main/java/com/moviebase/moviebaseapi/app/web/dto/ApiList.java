package com.moviebase.moviebaseapi.app.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "List", description = "List model")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiList implements IApiObject {

    @ApiModelProperty(notes = "Lists name")
    @NotNull(message = "Lists name must exist")
    private String name;

}
