package com.project.order.service;

import com.project.order.Mapper.OrderMapper;
import com.project.order.dto.OrderDTO;
import com.project.order.dto.OrderDTOFromFE;
import com.project.order.dto.UserDTO;
import com.project.order.entity.Order;
import com.project.order.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplate restTemplate;


    public OrderDTO saveOrderInDb(OrderDTOFromFE orderDetails) {
        Integer newOrderId = sequenceGenerator.generateNextOrderId();
        UserDTO userDTO = fetchOrderDetailsFromUserId(orderDetails.getUserId());
        Order orderToBeSaved = new Order(newOrderId, orderDetails.getFoodItemsList(), orderDetails.getRestaurant(), userDTO);
        orderRepo.save(orderToBeSaved);
        return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved);
    }

    private UserDTO fetchOrderDetailsFromUserId(Integer userId) {

        return restTemplate.getForObject(
                "http://USERINFORMATION/api/user/fetchUserById/{userId}",
                UserDTO.class,
                 userId
        );

    }
}
