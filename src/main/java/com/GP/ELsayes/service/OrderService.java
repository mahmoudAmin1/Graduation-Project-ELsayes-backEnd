package com.GP.ELsayes.service;


import com.GP.ELsayes.model.dto.OrderResponse;
import com.GP.ELsayes.model.dto.ServicesOfOrderResponse;
import com.GP.ELsayes.model.entity.Order;
import com.GP.ELsayes.model.enums.ProgressStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {
    public Order add(Long customerId) ;
    public Order update(Order updatedOrder);
    public void delete(Long aLong);
    public Optional<Order> getObjectById(Long orderId);
    public Order getById(Long orderId);
    public Optional<Order> getUnConfirmedByCustomerId(Long customerId);
    public OrderResponse getUnConfirmedOrderByCustomerId(Long customerId);
    public List<ServicesOfOrderResponse> getConfirmedOrderByCustomerId(Long customerId);
    public void confirmOrderByCustomerId(Long customerId);
    public void updateOrderStatus(Long orderId, ProgressStatus progressStatus);
    public void endTheOrder(Long orderId);




}