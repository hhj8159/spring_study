package com.hjham.di.test;

@FunctionalInterface // 함수형 인터페이스 추상메서드가 하나만 있어야함
public interface MyInter {
    // 추상메서드가 없거나 둘 이상이면 위반이다
    Integer run(String str);

    default Integer de(String str) {
        return Integer.parseInt(str);
    }
    
    static Integer sm(String str) {
        return Integer.parseInt(str);        
    }
    
}
