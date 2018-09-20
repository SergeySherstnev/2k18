package com.tsystems;

import com.tsystems.components.*;
import com.tsystems.components.Impl.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main (String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        context.getBean(Quoter.class).sayQuote();


        RoboDos robot = (RoboDos) context.getBean("RoboDos");
        robot.Action();
    }
}
