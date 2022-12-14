package com.eafonasyev.classes.aspect;


import com.eafonasyev.classes.dao.AccountD;
import com.eafonasyev.classes.dao.AccountDAO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(1)
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

    @AfterReturning(pointcut = "execution(* com.eafonasyev.classes.dao.AccountDAO.findAccounts(..))",
                    returning = "result")
    public void afterRetuningAccount(JoinPoint point, List<AccountD> result){
        System.out.println("AFTERETUNINGGGGGGGGGGG");
        System.out.println(point.getSignature());
        System.out.println(result.toString());
    }
}
