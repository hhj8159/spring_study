package com.hjham.aop.ex03.adv;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

public class SimpleAdvs extends StaticMethodMatcherPointcutAdvisor{

    @Override
    public boolean matches(Method method, Class<?> targetClass) {

        return method.getName().startsWith("one");
    }
    
}
