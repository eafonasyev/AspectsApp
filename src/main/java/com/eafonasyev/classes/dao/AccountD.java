package com.eafonasyev.classes.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountD {

    private String name;
    private int level;

    public String getName() {
        System.out.println("getName");
        return name;
    }

    public void setName(String name) {
        System.out.println("setName");
        this.name = name;
    }

    public int getLevel() {
        System.out.println("getLevel");
        return level;
    }

    public void setLevel(int level) {
        System.out.println("setLevel");
        this.level = level;
    }
}
