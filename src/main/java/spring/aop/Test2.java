package spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

/**
 * Класс для демонстрации Aspect-классов
 * с обработкой исключений и Aspect-методами c аннотациями:
 * @AfterReturning
 * @AfterThrowing
 * @After
 * */

public class Test2 {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        University university = context.getBean("university", University.class);

        university.addStudent();

        try {
        List<Student> students = university.getStudents();
        System.out.println(students);
        } catch (Exception e){
            System.out.println("Было поймано исключение - " + e);
        }

        context.close();

    }

}
