package com.GP.ELsayes.repository;

import com.GP.ELsayes.model.dto.ServiceResponse;
import com.GP.ELsayes.model.entity.ServiceEntity;
import com.GP.ELsayes.model.enums.ServiceCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface ServiceRepo extends JpaRepository<ServiceEntity,Long> {

    @Query("select s from ServiceEntity s join s.servicesOfBranch sb join sb.branch b where b.id = :branchId")
    List<ServiceEntity> findAllByBranchId(Long branchId);


    @Query("select s from ServiceEntity s join s.servicesOfBranch sb where sb.service.id = :serviceId and sb.branch.id = :branchId")
    Optional<ServiceEntity> findByServiceIdAndBranchId(Long serviceId, Long branchId);


    @Query("select s from ServiceEntity s join s.servicesOfBranch sb where sb.serviceStatus = 'AVAILABLE' and sb.service.id = :serviceId and sb.branch.id = :branchId")
    Optional<ServiceEntity> findByServiceIdAndBranchIdIfAvailable(Long serviceId, Long branchId);

    @Query("select s from ServiceEntity s join s.servicesOfBranch sb where sb.branch.id = :branchId and sb.serviceStatus = 'AVAILABLE'")
    List<ServiceEntity> findAllAvailableInBranch(Long branchId);

    @Query("select s from ServiceEntity s join s.servicesOfPackage so join so.packageEntity o where o.id = :packageId")
    List<ServiceEntity> findAllByPackageId(Long packageId);
    @Query("select s from ServiceEntity s join s.servicesOfOrder so join so.order o where o.id = :orderId")
    List<ServiceEntity> findAllByOrderId(Long orderId);

    @Query("SELECT s FROM ServiceEntity s WHERE s.serviceCategory = :category")
    List<ServiceEntity> findAllByCategory(ServiceCategory category);
}



