package com.app.crudapi.model.table;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Length(message = "Minimal 10 karakter", min = 10)
    private String fullName;
    @Length(message = "Maksimal 10 karakter", max = 10)
    private String lastName;
    private String address;
    private String gender;
    private String username;
    @Pattern(message = "Harus berupa huruf dan angka", regexp = "^[a-zA-Z0-9]+$")
    private String password;

}
