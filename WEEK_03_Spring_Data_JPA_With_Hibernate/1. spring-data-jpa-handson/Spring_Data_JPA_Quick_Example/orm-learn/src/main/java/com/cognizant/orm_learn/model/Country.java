package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="country")
@Getter
@Setter
public class Country {

    @Id
    @Column(name="co_code")
    private String code;

    @Column(name="co_name")
    private String name;

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}
