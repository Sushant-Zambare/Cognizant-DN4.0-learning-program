package com.cognizant.spring_learn.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Department {

    @NotNull
    private Integer id;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 30)
    private String name;
}