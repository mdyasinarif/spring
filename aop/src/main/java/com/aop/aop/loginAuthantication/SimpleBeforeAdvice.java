package com.aop.aop.loginAuthantication;

import com.aop.aop.apoConcept.MessageWriter;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {
    public static void main(String[] args) {
        MessageWriter target = new MessageWriter();


        ProxyFactory pf = new ProxyFactory();

        pf.addAdvice(new SimpleBeforeAdvice());
        pf.setTarget(target);

        MessageWriter proxy = (MessageWriter) pf.getProxy();

        proxy.writeMessage();
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Befour method :" + method.getName());
    }
}
