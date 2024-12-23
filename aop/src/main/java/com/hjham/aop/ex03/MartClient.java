package com.hjham.aop.ex03;

import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import com.hjham.aop.ex02.adv.Pakaging;
import com.hjham.aop.ex03.adv.ThrowLog;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MartClient {
    public static void main(String[] args) {
        // Mart mart = new MartImpl();        
        // 1. ProxyFactory 생성
        ProxyFactory factory = new ProxyFactory();
        // 2. target을 MartImpl로 지정
        factory.setTarget(new MartImpl());
        // 3. ex02의 pakaging을 advice로 지정
        factory.addAdvice(new Pakaging());
        // 4. ex03의 ThrowLog를 advice로 지정
        factory.addAdvice(new ThrowLog());    
        // 5. proxy객체 생성 후 getName호출
        try {
            ((Mart)factory.getProxy()).getProduct("물티슈");
            // Mart mart2 = (Mart)factory.getProxy();
            // mart2.getProduct("물티슈");
        }
        catch(RuntimeException r) {
            log.error(r.getMessage());
        }


    }    
}
