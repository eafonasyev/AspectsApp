package com.eafonasyev.classes.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    public void addAccount(AccountD account,int i){

        System.out.println(getClass()+" AccountDAO doing add Account!!!");
    }
}
