package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        // read spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // get the bean from spring container
        // Component Annotation을 통해 특정한 name을 정의하지 않았을 때, getBean method의 name 파라미터에 해당 Class-name의
        // 맨 앞 글자만 소문자로 바꾼 이름을 사용할 수 있다. (default로 적용됌)
        // ex) 'class TennisCoach => name : "tennisCoach"
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        // call a method on the bean
        System.out.println(theCoach.getDailyWorkout());

        // close the context
        context.close();
    }
}
