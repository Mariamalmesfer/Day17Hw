package com.example.usersmanagementhw17.Model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    @NotNull(message = "This fields is required")
    private Integer id;


    @NotEmpty(message = "This fields is required")
    @Size(min = 5 ,message = "name must be more that 4")
    private String name;



    @NotEmpty(message = "This fields is required")
    @Size(min = 5, message = "must be more that 4")
    @Column(unique = true)
    private String username;

    @NotEmpty(message = "This fields is required")
    private String password;

    @NotEmpty(message = "This fields is required")
    @Email
    @Column(unique = true)
    private String email;

    @Pattern(regexp = "^(user|admin)$" , message = "must be user or admin")
    private String role;

    @NotNull
    private Integer age;


}
