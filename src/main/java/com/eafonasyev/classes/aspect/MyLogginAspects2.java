package com.eafonasyev.classes.aspect;

import com.eafonasyev.classes.dao.AccountD;
import com.eafonasyev.classes.dao.AccountDAO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(-2)
public class MyLogginAspects2 {
    @Pointcut("execution( * com.eafonasyev.classes.dao.AccountDAO.addAccount(..))")
    private void poincutMethod(){};

    @Pointcut("execution( * com.eafonasyev.classes.dao.*.set*(..))")
    private void setter(){

    };

    @Pointcut("execution( * com.eafonasyev.classes.dao.*.get*(..))")
    private void getter(){};

    @Pointcut("poincutMethod() &&!(getter() || setter())")
    private void combsin(){};

    @Before("execution(public void updateAccount())")
    public void beforeaUpdateAccount(JoinPoint point){

        MethodSignature signature = (MethodSignature) point.getSignature();
        System.out.println("signature 222:" + signature);
        System.out.println("run at first beforeaupdateAccount2222");
    }

    @After("execution(public void updateAccount())")
    public void afterUpdateAccount(){
        System.out.println("run at last afterupdateAccount2222");
    }


    @Before("combsin()")
    public void beforeaAddAccount(JoinPoint point){
        MethodSignature signature = (MethodSignature) point.getSignature();
        System.out.println("signature 222:" + signature);
        System.out.println("run at first beforeaaddAccount2222");

        Object[] arg = point.getArgs();
        for(Object argg : arg){
            System.out.println("555  "+ argg.toString());
        }
    }

    @After("combsin()")
    public void afterAddAccount(){
        System.out.println("run at last afteraddeAccount2222");
    }

    @AfterReturning(pointcut = "execution(* com.eafonasyev.classes.dao.AccountDAO.findAccounts(..))",
    returning = "result")
    public void afterRetuningAccount(JoinPoint point, List<AccountD> result){
        System.out.println("AFTERETUNINGGGGGGGGGGG");
        System.out.println(point.getSignature());
        System.out.println(result.toString());
    }
}
