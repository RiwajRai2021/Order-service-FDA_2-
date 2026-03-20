package com.project.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTOFromFE {

    List<FoodItemsDTO> foodItemsList;
    private Integer userId;
    private Restaurant restaurant;





}
