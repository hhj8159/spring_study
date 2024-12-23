package com.hjham.di.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Stream.of(1,2,3,4,5).toList());
        log.info(list);
        
        // comparator는 interface
        Comparator<Integer> c = (a, b) -> b - a;
        // list.sort((a, b) -> b-a);
        list.sort(c);
        log.info(list);

        MyInter myInter = new MyInter() {
            public Integer run(String str) {
                return 10;
            }
        };

        log.info(myInter.de("100"));
        log.info(myInter.run(""));

        log.info(MyInter.sm("30"));
        
        // Myinter myInter2 = a -> 50;
        // Myinter myInter2 = (a) -> {return 50;};
        // log.info(myInter2.run(null));
    }
}
