package com.hunter.dao.order;

import com.hunter.entity.order.User;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao {
    User selectByPrimaryKey(Integer id);
}
