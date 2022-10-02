package com.eafonasyev.classes.aspect;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLogginAspect {

    @Pointcut("execution( * com.eafonasyev.classes.dao.*.*(..))")
    private void poincutMethod(){};

    @Pointcut("execution( * com.eafonasyev.classes.dao.*.set*(..))")
    private void setter(){};

    @Pointcut("execution( * com.eafonasyev.classes.dao.*.get*(..))")
    private void getter(){};

    @Pointcut("poincutMethod() &&!(getter() || setter())")
    private void combsin(){};

    @Before("execution(public void updateAccount())")
    public void beforeaUpdateAccount(){
        System.out.println("run at first beforeaupdateAccount");
    }

    @After("execution(public void updateAccount())")
    public void afterUpdateAccount(){
        System.out.println("run at last afterupdateAccount");
    }


    @Before("combsin()")
    public void beforeaAddAccount(){
        System.out.println("run at first beforeaaddAccount");
    }

    @After("combsin()")
    public void afterAddAccount(){
        System.out.println("run at last afteraddeAccount");
    }
}
