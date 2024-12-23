package com.hjham.aop.ex01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class HelloWorldHandler<T> implements InvocationHandler{
    private T t;
    public HelloWorldHandler(T t) {
        this.t = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        Object o = method.invoke(t, args);
        method.invoke(t, args);
        log.info(System.currentTimeMillis() - start + "ms");
        return o;
    }
    
}
