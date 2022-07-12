package spring.aop;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Класс для демострации Aspect-класс с аннотацией @Around
 * */
public class Test3 {

    public static void main(String[] args) {

        System.out.println("Method main starts");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Library library = context.getBean("library", Library.class);

        String bookName = library.returnBook();

        System.out.println("В библиотеку вернули книгу - " + bookName);

        context.close();

        System.out.println("Method main ends");

    }

}
