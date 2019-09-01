package com.hunter.schematask;

import com.hunter.dao.cust.CustDao;
import com.hunter.dao.order.OrderDao;
import com.hunter.entity.cust.Money;
import com.hunter.entity.order.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class PaymodeSchemaTask {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CustDao custDao;

    @Scheduled(cron = "0/5 * * * * ?")
    public void doSchemaTask() {

        Money money = custDao.selectByPrimaryKey(1);
        User user = orderDao.selectByPrimaryKey(1);
        System.out.println(money.toString());
        System.out.println(user.toString());
    }
}
