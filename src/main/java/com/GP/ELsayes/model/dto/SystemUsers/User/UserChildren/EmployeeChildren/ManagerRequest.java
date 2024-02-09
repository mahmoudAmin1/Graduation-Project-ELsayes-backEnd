package com.GP.ELsayes.model.dto.SystemUsers.User.UserChildren.EmployeeChildren;


import com.GP.ELsayes.model.dto.SystemUsers.User.UserChildren.EmployeeRequest;
import com.GP.ELsayes.model.enums.permissions.ManagerPermission;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ManagerRequest extends EmployeeRequest {

    @NotNull(message = "Manager Permission must not be null")
    private ManagerPermission managerPermission;


    @NotNull(message = "Branch id must not be null")
    private Long branchId;

}
