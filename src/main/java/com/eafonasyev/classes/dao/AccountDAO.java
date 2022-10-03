package com.eafonasyev.classes.dao;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {
    public void addAccount(AccountD account,int i){

        System.out.println(getClass()+" AccountDAO doing add Account!!!");
    }
    public List<AccountD> findAccounts(){

        List<AccountD> myAccounts = new ArrayList<AccountD>();
        AccountD  ac1 = new AccountD("jOHN",1);
        AccountD  ac2 = new AccountD("lena",1);
        AccountD  ac3 = new AccountD("Petr",2);

        myAccounts.add(ac1);
        myAccounts.add(ac2);
        myAccounts.add(ac3);

        return  myAccounts;
    }
}
