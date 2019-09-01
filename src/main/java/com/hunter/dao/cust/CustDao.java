package com.hunter.dao.cust;

import com.hunter.entity.cust.Money;
import org.springframework.stereotype.Repository;

@Repository
public interface CustDao {
    Money selectByPrimaryKey(Integer id);
}
