package org.springXML;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello getting starting...");
        ApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
        Alien obj = context.getBean("alien", Alien.class);
        obj.code();

        Laptop lapTest = (Laptop) context.getBean("lap1");
        lapTest.use();

    }
}
