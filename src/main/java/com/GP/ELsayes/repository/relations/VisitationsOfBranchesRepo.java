package com.GP.ELsayes.repository.relations;

import com.GP.ELsayes.model.entity.relations.VisitationsOfBranches;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface VisitationsOfBranchesRepo extends JpaRepository<VisitationsOfBranches, Long> {

    /**
     * Finds the current visitation record for a car with a given plate number at a specific branch.
     * This method returns an Optional containing the visitation if the car is currently present (dateOfLeaving is not null),
     * otherwise, it returns an empty Optional.

     * @return an Optional containing the current visitation record, if found
     */
    @Query("SELECT cv FROM VisitationsOfBranches cv JOIN cv.car c WHERE c.carPlateNumber = :carPlateNumber" +
            " AND cv.branch.id = :branchId AND cv.dateOfLeaving IS NULL")
    Optional<VisitationsOfBranches> findCurrentlyByCarPlateNumberAndBranchId(String carPlateNumber, Long branchId);

    /**
     * Retrieves the most recent visitation record for a car with a given plate number at a specific branch.
     * The results are ordered by the date of arrival in descending order, ensuring the most recent record is returned first.
     * This method returns a Page of VisitationsOfBranches, which should be limited to a single result.

     * @param pageable a Pageable object to limit the query to the most recent record
     * @return a Page containing the most recent visitation record, if found
     */
    @Query("SELECT cv FROM VisitationsOfBranches cv JOIN cv.car c WHERE c.carPlateNumber = :carPlateNumber" +
            " AND cv.branch.id = :branchId ORDER BY cv.dateOfArriving DESC")
    Page<VisitationsOfBranches> findRecentByCarPlateNumberAndBranchId(String carPlateNumber, Long branchId, Pageable pageable);

    @Query("SELECT cv FROM VisitationsOfBranches cv WHERE" +
            " cv.branch.id = :branchId AND cv.dateOfLeaving IS NULL")
    List<VisitationsOfBranches> findAllCurrentVisitationsInBranch(Long branchId);
    @Query("SELECT cv FROM VisitationsOfBranches cv WHERE " +
            "cv.branch.id = :branchId AND EXTRACT(DAY FROM cv.dateOfArriving) = EXTRACT(DAY FROM :date)")
    List<VisitationsOfBranches> findAVisitationsInBranchByADate(Long branchId, Date date );

    @Query("SELECT v FROM VisitationsOfBranches v WHERE v.customer.id = :customerId AND v.dateOfLeaving IS NULL")
    Optional<VisitationsOfBranches> findCurrentVisitationByCustomerId(Long customerId);

    @Query("SELECT COUNT(v) FROM VisitationsOfBranches v WHERE v.branch.id = :branchId AND v.dateOfLeaving IS NULL")
    String findCountOfCurrentVisitationByBranchId(Long branchId);
}