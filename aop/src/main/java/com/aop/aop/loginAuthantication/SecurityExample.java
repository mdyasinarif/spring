package com.aop.aop.loginAuthantication;

import org.springframework.aop.framework.ProxyFactory;

public class SecurityExample {
    public static void main(String[] args) {
        SecurityManager mgr = new SecurityManager();

        SecureBean bean = getSeureBean();

        mgr.login("Yasin", "pwd");
        bean.writeSecureMessage();
        mgr.logout();

        try {
            mgr.login("arif", "pwd");
            bean.writeSecureMessage();
        } catch (SecurityException ex) {
            System.out.println("Exception Caught: " + ex.getMessage());
        } finally {
            mgr.logout();
        }

        try {
            bean.writeSecureMessage();
        } catch (SecurityException ex) {
            System.out.println("Exception Caught: " + ex.getMessage());
        }
    }

    private static SecureBean getSeureBean() {
        SecureBean target = new SecureBean();

        SecutityAdvice advice = new SecutityAdvice();

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(advice);
        SecureBean proxy = (SecureBean) factory.getProxy();
        return proxy;
    }
}
