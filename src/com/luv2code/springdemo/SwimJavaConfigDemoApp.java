package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        // get the bean from spring container
        // Component Annotation을 통해 특정한 name을 정의하지 않았을 때, getBean method의 name 파라미터에 해당 Class-name의
        // 맨 앞 글자만 소문자로 바꾼 이름을 사용할 수 있다. (default로 적용됌)
        // ex) class TennisCoach => name : "tennisCoach"
        SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

        // call a method on the bean
        System.out.println(theCoach.getDailyWorkout());

        // call a method on the bean
        System.out.println(theCoach.getDailyFortune());

        // call our new swim coach methods ... has the props values injected
        System.out.println("email: " + theCoach.getEmail());
        System.out.println("email: " + theCoach.getTeam());

        // close the context
        context.close();
    }
}
