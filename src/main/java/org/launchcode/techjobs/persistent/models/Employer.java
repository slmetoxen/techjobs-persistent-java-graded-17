package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Employer extends AbstractEntity {
    @NotEmpty(message = "Location is required.")
    @Size(max = 75, message = "Location title is too long!")
    private String location;

    public Employer() {}

}