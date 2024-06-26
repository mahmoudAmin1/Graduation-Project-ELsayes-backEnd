package com.GP.ELsayes.repository;

import com.GP.ELsayes.model.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BranchRepo extends JpaRepository<Branch,Long> {
    @Query("SELECT branch FROM Branch branch WHERE branch.manager.id = :managerId")
    Optional<Branch> findByManagerId(Long managerId);
    
    @Query("SELECT b FROM Branch b JOIN b.workers w WHERE w.id = :workerId")
    Optional<Branch> findByWorkerId(Long workerId);

//    @Query("SELECT branch FROM Branch branch JOIN branch.packagesOfBranch packageBranch JOIN packageBranch.packageEntity package" +
//            " WHERE package.id = :packageId")
    @Query("SELECT branch FROM Branch branch JOIN branch.packagesOfBranch packageBranch WHERE packageBranch.packageEntity.id = :packageId" +
            " AND packageBranch.packageStatus = 'AVAILABLE'")
    List<Branch> findAllByPackageId(Long packageId);
    //@Query("select b from Branch b join b.servicesOfBranch bs join bs.service s where s.id = :serviceId")
    @Query("SELECT b FROM Branch b JOIN b.servicesOfBranch bs WHERE bs.service.id = :serviceId AND bs.serviceStatus = 'AVAILABLE'")
    List<Branch> findAllByServiceId(Long serviceId);
}
