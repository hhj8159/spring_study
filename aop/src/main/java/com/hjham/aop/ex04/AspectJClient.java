package com.hjham.aop.ex04;

import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import com.hjham.aop.ex02.adv.Seasoning;
import com.hjham.aop.ex02.adv.Sourcing;

public class AspectJClient {
    public static void main(String[] args) {
        AspectJExpressionPointcut pc = new AspectJExpressionPointcut();
        pc.setExpression("execution(* two*(..))");

        Advisor advisor = new DefaultPointcutAdvisor(pc, new Seasoning());

        ProxyFactory factory = new ProxyFactory(new First());
        factory.addAdvisor(advisor);
        ((First)factory.getProxy()).one();
        ((First)factory.getProxy()).two();
        ((First)factory.getProxy()).two2();

        factory = new ProxyFactory(new Second());
        factory.addAdvisor(advisor);
        ((Second)factory.getProxy()).one();
        ((Second)factory.getProxy()).two();
    }
}
