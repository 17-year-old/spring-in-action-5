package com.fubailin.tacos.data;

import com.fubailin.tacos.Order;

public interface OrderRepository {
    Order save(Order order);
}
