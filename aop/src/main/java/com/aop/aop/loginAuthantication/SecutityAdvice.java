package com.aop.aop.loginAuthantication;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class SecutityAdvice implements MethodBeforeAdvice {
    private SecurityManager securityManager;

    public SecutityAdvice() {
        this.securityManager = new SecurityManager();
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        UserInfo user = securityManager.getLoggedOnUser();
        if (user == null) {
            System.out.println("No user authenticated");
            throw new SecurityException("You must login before attempting to invoke the method : " + method.getName());
        } else if ("Yasin".equals(user.getUserName())) {
            System.out.println("Logged in user is clarence - OKAY!");
        } else {
            System.out.println("Logged in user is " + user.getUserName() + " Not Good : (");
            throw new SecurityException("User " + user.getUserName() + " is not allowed access to method " + method.getName());
        }
    }
}
