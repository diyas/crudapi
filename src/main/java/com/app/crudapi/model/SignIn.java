package com.app.crudapi.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class SignIn {
    @NotEmpty(message = "username tidak boleh kosong!")
    private String userName;
    @Pattern(message = "password harus berupa huruf dan angka",regexp = "^[a-zA-Z0-9]+$")
    private String password;
}
