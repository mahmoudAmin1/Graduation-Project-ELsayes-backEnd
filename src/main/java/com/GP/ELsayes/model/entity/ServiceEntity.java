package com.GP.ELsayes.model.entity;

import com.GP.ELsayes.model.entity.relations.ManagersOfServices;
import com.GP.ELsayes.model.entity.relations.ServicesOfBranches;
import com.GP.ELsayes.model.entity.relations.ServicesOfPackage;
import com.GP.ELsayes.model.entity.relations.ServicesOfOrders;
import com.GP.ELsayes.model.enums.ServiceCategory;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor


    @Entity
    @Table(name = "service")
    public class ServiceEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "service_id")
        private Long id;

        private String name;
        private String description;

        @Lob
        @Column(columnDefinition = "LONGBLOB")
        private String image;
        private String price;
        private String requiredTime;

        @Enumerated(EnumType.STRING)
        private ServiceCategory serviceCategory;

        private String profitOfDay;
        private String profitOfMonth;
        private String profitOfYear;
        private String totalProfit;


        @JsonManagedReference
        @OneToMany(mappedBy = "service")
        private List<ManagersOfServices> managersOfService;

        @JsonManagedReference
        @OneToMany(mappedBy = "service",cascade = CascadeType.REMOVE)
        private List<ServicesOfBranches> servicesOfBranch;



        @JsonManagedReference
        @OneToMany(mappedBy = "service")
        private List<ServicesOfPackage> servicesOfPackage ;

        @JsonManagedReference
        @OneToMany(mappedBy = "service")
        private List<ServicesOfOrders> servicesOfOrder;

    }

