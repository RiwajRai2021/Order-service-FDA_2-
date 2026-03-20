package com.project.order.Mapper;

import com.project.order.dto.OrderDTO;
import com.project.order.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order mapOrderDTOToOrder(OrderDTO oderDTO);
    OrderDTO mapOrderToOrderDTO(Order order);

}
