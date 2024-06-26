package com.GP.ELsayes.model.mapper.relations;

import com.GP.ELsayes.model.dto.ServiceResponse;
import com.GP.ELsayes.model.dto.ServicesOfOrderResponse;
import com.GP.ELsayes.model.entity.ServiceEntity;
import com.GP.ELsayes.model.entity.relations.ServicesOfBranches;
import com.GP.ELsayes.model.entity.relations.ServicesOfOrders;
import com.GP.ELsayes.model.enums.Status;
import com.GP.ELsayes.service.ServiceService;
import com.GP.ELsayes.service.relations.ServicesOfBranchesService;
import com.GP.ELsayes.service.relations.ServicesOfOrderService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ServicesOfOrderMapper {

    @Mapping(source = "entity.service.name", target = "serviceName")
    @Mapping(source = "entity.service.price", target = "servicePrice")
    @Mapping(source = "entity.service.requiredTime", target = "requiredTime")
    @Mapping(source = "entity.service.image", target = "image")
    @Mapping(source = "entity.worker.firstName", target = "workerName")
    ServicesOfOrderResponse toResponse(ServicesOfOrders entity);


    @Mapping(source = "entity.service.name", target = "serviceName")
    @Mapping(source = "entity.service.price", target = "servicePrice")
    @Mapping(source = "entity.service.requiredTime", target = "requiredTime")
    @Mapping(source = "entity.service.image", target = "image")
    @Mapping(target = "availableInBranch", expression = "java(isAvailableInBranch(entity.getService().getId(), branchId, serviceService))")
    ServicesOfOrderResponse toResponseAccordingToBranch(ServicesOfOrders entity, Long branchId, ServiceService serviceService);


    
    default Boolean isAvailableInBranch(Long serviceId, Long branchId, ServiceService serviceService) {
        return serviceService.isAvailableInBranch(serviceId,branchId);
    }

}
