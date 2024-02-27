package com.GP.ELsayes.service;

import com.GP.ELsayes.model.dto.SystemUsers.User.UserChildren.CustomerRequest;
import com.GP.ELsayes.model.dto.SystemUsers.User.UserChildren.CustomerResponse;
import com.GP.ELsayes.model.entity.SystemUsers.userChildren.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService extends CrudService<CustomerRequest, Customer, CustomerResponse,Long> {
}