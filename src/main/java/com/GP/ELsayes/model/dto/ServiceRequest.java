package com.GP.ELsayes.model.dto;

import com.GP.ELsayes.model.enums.ServiceCategory;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceRequest {

    @NotNull(message = "Name must not be null")
    @NotEmpty(message = "Name must not be empty")
    private String name;

    @NotNull(message = "Description must not be null")
    @NotEmpty(message = "Description must not be empty")
    private String description;

    @NotNull(message = "Image must not be null")
    @NotEmpty(message = "Image must not be empty")
    private String image;

    @NotNull(message = "Price must not be null")
    @NotEmpty(message = "Price must not be empty")
    private String price;

    @NotNull(message = "Required time must not be null")
    @NotEmpty(message = "Required time must not be empty")
    private String requiredTime;

    @NotNull(message = "Service category must not be null")
    private ServiceCategory serviceCategory;

    @NotNull(message = "Manager id created this service must not be null")
    private Long managerId;
}
