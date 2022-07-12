package spring.aop;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Класс для запуска и демонстрации Aspect-классов
 * LoggingAspect
 * SecurityAspect
 * ExceptionHandlingAspect
 * */

public class Test1 {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Library library = context.getBean("library", Library.class);
        Book book = context.getBean("book", Book.class);

//        library.getBook();
//        library.returnBook();
        library.addBook("PersonName", book);

//        library.getMagazine();
//        library.returnMagazine();
        library.addMagazine();


        context.close();

    }

}
