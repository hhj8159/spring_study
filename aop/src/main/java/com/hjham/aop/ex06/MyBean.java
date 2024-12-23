package com.hjham.aop.ex06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
// @AllArgsConstructor
public class MyBean {
    @Autowired
    private MyDependency myDependency;

    public void run() {
        myDependency.hello(8000);
        myDependency.hello(4000);
        myDependency.bye();
    }
}
