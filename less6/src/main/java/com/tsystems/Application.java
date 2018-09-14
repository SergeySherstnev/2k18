package com.tsystems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tsystems.dao.*;
import com.tsystems.model.*;
import com.tsystems.config.*;
import org.springframework.stereotype.Component;

@Component
public class Application {

    @Autowired
    UserDao userDao;

    public static void main(String[] args) {
        //создаем контекст для взаимодействия , т.к. main не может общаться с методами run
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class, HibernateConfig.class);

        Application app = ctx.getBean(Application.class);
        app.run();

    }

    public void run() {
        User user =new User("Aleksander","SPb, Novaya str 15");
        userDao.saveUser(user);
        System.out.println(userDao.getAll());
    }
}
