package com.GP.ELsayes.model.mapper;

import com.GP.ELsayes.model.dto.SystemUsers.User.EditUserProfileRequest;
import com.GP.ELsayes.model.dto.SystemUsers.User.UserChildren.CustomerRequest;
import com.GP.ELsayes.model.dto.SystemUsers.User.UserChildren.CustomerResponse;
import com.GP.ELsayes.model.dto.SystemUsers.User.UserChildren.EmployeeChildren.ManagerRequest;
import com.GP.ELsayes.model.dto.SystemUsers.User.UserChildren.EmployeeChildren.ManagerResponse;
import com.GP.ELsayes.model.dto.SystemUsers.User.UserChildren.EmployeeChildren.WorkerRequest;
import com.GP.ELsayes.model.dto.SystemUsers.User.UserChildren.EmployeeChildren.WorkerResponse;
import com.GP.ELsayes.model.dto.SystemUsers.User.UserChildren.OwnerRequest;
import com.GP.ELsayes.model.dto.SystemUsers.User.UserChildren.OwnerResponse;
import com.GP.ELsayes.model.dto.SystemUsers.User.UserRequest;
import com.GP.ELsayes.model.dto.SystemUsers.User.UserResponse;
import com.GP.ELsayes.model.entity.SystemUsers.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    OwnerRequest toOwnerRequest(EditUserProfileRequest profileRequest);
    OwnerRequest toOwnerRequest(UserRequest userRequest);
    UserResponse toUserResponse(OwnerResponse ownerResponse);

    CustomerRequest toCustomerRequest(EditUserProfileRequest profileRequest);
    UserResponse toUserResponse(CustomerResponse customerResponse);

    ManagerRequest toManagerRequest(EditUserProfileRequest profileRequest);
    UserResponse toUserResponse(ManagerResponse managerResponse);

    WorkerRequest toWorkerRequest(EditUserProfileRequest profileRequest);
    UserResponse toUserResponse(WorkerResponse workerResponse);

    User toEntity(EditUserProfileRequest profileRequest);
    UserResponse toResponse(User updatedUser);
}
