package com.moviebase.moviebaseapi.app.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@ApiModel(value = "User", description = "User model")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiUser implements IApiObject {

    @ApiModelProperty(notes = "Users first name")
    private String firstName;
    @ApiModelProperty(notes = "Users last name")
    private String lastName;

    @Email(message = "User's email must be valid")
    @ApiModelProperty(notes = "Users email")
    private String email;

    @NotNull(message = "Users username must exist")
    @ApiModelProperty(notes = "Users username")
    private String username;

    @NotNull(message = "Users password must exist")
    @Size(min = 8, message = "Users password must be at least 8 chars long")
    @ApiModelProperty(notes = "Users password")
    private String password;

}
