package com.fubailin.tacocloud.data;

import com.fubailin.tacocloud.Order;

public interface OrderRepository {
    Order save(Order order);
}
