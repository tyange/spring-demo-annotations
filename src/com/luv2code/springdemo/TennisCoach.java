package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach {

    // Qualifier annotation은 Component annotation이 들어간 특정 컴포넌트를 지정해서 Autowired로 연결한다.
    // Component annotaion의 name-convention과 똑같이 맨 앞의 문자만 소문자로 변경해서 쓴다.
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    // define a default constructor
    public TennisCoach() {
        System.out.println(">> TennisCoach: inside default constructor");
    }

    // define my init method
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println(">> TennisCoach: inside of doMyStartupStuff");
    }

    // define my destroy method
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println(">> TennisCoach: inside of doMyCleanupStuff");
    }

    // define a setter method
    // @Autowired
    // public void doSomeCrazyStuff(FortuneService theFortuneService) {
    //     System.out.println(">> TennisCoach: inside default doSomeCrazyStuff() method");
    //     fortuneService = theFortuneService;
    // }

    // @Autowired
    // public TennisCoach(FortuneService theFortuneService) {
    //     fortuneService = theFortuneService;
    // }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
