package com.eafonasyev.classes;

import com.eafonasyev.classes.config.DemoConfig;
import com.eafonasyev.classes.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO account;

        account = context.getBean("accountDAO",AccountDAO.class);

        account.addAccount();
    }
}
