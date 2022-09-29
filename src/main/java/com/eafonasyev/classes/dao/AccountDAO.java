package com.eafonasyev.classes.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    public void addAccount(){

        System.out.println(getClass()+"  doing add Account!!!");
    }
}
