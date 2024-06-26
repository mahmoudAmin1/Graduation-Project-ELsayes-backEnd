package com.GP.ELsayes.model.dto;

import com.GP.ELsayes.model.enums.ServiceCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceResponse {

    private Long id;
    private String name;
    private String description;
    private String image;
    private String price;
    private String requiredTime;
    private ServiceCategory serviceCategory;
    private Boolean availableInBranch;

    private String profitOfDay;
    private String profitOfMonth;
    private String profitOfYear;
    private String totalProfit;
}
