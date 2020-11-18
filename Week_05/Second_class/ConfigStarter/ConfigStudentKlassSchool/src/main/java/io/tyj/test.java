package io.tyj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication()
public class test {
    public static void main(String[] args) {
        ApplicationContext context =  SpringApplication.run(test.class, args);
        final Student student = context.getBean(Student.class);
        student.init();
        System.out.println(student);

        System.out.println("--- Klass ---");
        final Klass klass = context.getBean(Klass.class);
        System.out.println(klass);

        System.out.println("--- School ---");
        final School school = context.getBean(School.class);
        System.out.println(school);
    }
}
