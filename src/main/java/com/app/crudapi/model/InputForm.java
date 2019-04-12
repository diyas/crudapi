package com.app.crudapi.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
public class InputForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(message = "Minimal 5 huruf!",min = 5)
    private String fullName;
    @NotEmpty(message = "Harus Di isi!")
    private String lastName;
    @NotEmpty(message = "Harus Di isi!")
    private String address;
    @Email(message = "Format Email tidak sesuai!")
    private String email;
    @Pattern(message = "Harus berupa angka", regexp = "^[0-9]+$")
    @Size(message = "Maksimal 12 angka", max = 12)
    private String noHp;
}
