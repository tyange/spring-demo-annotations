package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
        //  load spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //  retrieve bean from spring
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        //  check if they are the same
        boolean result = (theCoach == alphaCoach);

        //  print out the results
        //  spring의 default scope는 singleton이다. singleton은 '언제나 같은 단 하나의 인스턴스'를 생성하는 것을 뜻한다.
        //  Scope annotation으로 별도의 scope를 지정해주지 않는다면 아래의 결과 값은 true, 그리고 같은 메모리 주소 값을 두 번 출력한다.
        //  별도의 Scope가 지정된 경우(ex. 현재 TennisCoach에 지정된 'prototype'), false 그리고 각각의 다른 메모리 주소를 한 번씩 출력한다.
        System.out.println("\nPointing to the same object: " + result);

        System.out.println("\nMemory location for theCoach: " + theCoach);

        System.out.println("\nMemory location for alphaCoach: " + alphaCoach + "\n");

        // close the context
        context.close();
    }
}
