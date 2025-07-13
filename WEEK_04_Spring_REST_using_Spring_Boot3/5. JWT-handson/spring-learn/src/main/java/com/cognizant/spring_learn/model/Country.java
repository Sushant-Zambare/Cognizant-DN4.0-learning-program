package com.cognizant.spring_learn.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Country {

    @NotNull
    @Size(min=2, max=2, message="Country code should be 2 characters")
    private String code;

    private String name;

    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
