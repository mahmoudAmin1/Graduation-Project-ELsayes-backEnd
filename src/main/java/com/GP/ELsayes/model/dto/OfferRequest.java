package com.GP.ELsayes.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferRequest {

    @NotNull(message = "Name must not be null")
    @NotEmpty(message = "Name must not be empty")
    private String name;

    @NotNull(message = "Description must not be null")
    @NotEmpty(message = "Description must not be empty")
    private String description;

    @NotNull(message = "Image must not be null")
    @NotEmpty(message = "Image must not be empty")
    private String offerImageURL;

    private String offerPercentage;

    @NotNull(message = "Manager id must not be null")
    private Long managerId;
}