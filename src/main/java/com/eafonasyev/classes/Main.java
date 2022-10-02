package com.eafonasyev.classes;

import com.eafonasyev.classes.config.DemoConfig;

import com.eafonasyev.classes.dao.AccountD;
import com.eafonasyev.classes.dao.AccountDAO;
import com.eafonasyev.classes.dao.MemeberShipDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {



        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);


        AccountD account1 ;
        account1 = context.getBean("accountD",AccountD.class);

        AccountDAO account;
        account = context.getBean("accountDAO",AccountDAO.class);
        account.addAccount(account1,1);

        String name;
        name = account1.getName();
        account1.setName("ggg");


        MemeberShipDao memeberShipDao;

        memeberShipDao = context.getBean("memeberShipDao",MemeberShipDao.class);

        memeberShipDao.addAccount();
    }
}
