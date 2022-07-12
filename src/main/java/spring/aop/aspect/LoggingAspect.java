package spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import spring.aop.Book;

@Component
@Aspect
@Order(1) // указывает порядок выполнения Aspect-классов
public class LoggingAspect {

    /** Pointcut объявленный из другого класса c JoinPoint в параметрах*/
    @Before("spring.aop.aspect.MyPointcuts.addMethodsFromLibrary()")
    public void beforeAddMethodsLoggingAspect(JoinPoint joinPoint){

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("methodSignature = "
                + methodSignature);
        System.out.println("methodSignature.getMethod() = "
                + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType() = "
                + methodSignature.getReturnType());
        System.out.println("methodSignature.getName() = "
                + methodSignature.getName());

        // Если имя метода addBook(), то записываем аргументы в массив Object
        if (methodSignature.getName().equals("addBook")){
            Object[] arguments = joinPoint.getArgs();
            for (Object obj : arguments){
                // Если было происхождение объекта Book, то выводем информацию о книге,
                // иначе если было происхождение объекта String, то выводим информацию кто добавил книгу
                if (obj instanceof Book){
                    Book myBook = (Book) obj;
                    System.out.println("Информация о книге: "
                            + "название - " + myBook.getNameBook()
                            + ", автор - " + myBook.getAuthor()
                            + ", год публикации - " + myBook.getYearOfPublication());
                }
                else if (obj instanceof String){
                    System.out.println("Книгу в библиотеку добавляет - " + obj);
                }
            }
        }

        System.out.println("beforeAddMethodsLoggingAspect: writing Log #20");
    }


    /** Комбинированный Pointcut с логированием всех методов кроме returnMagazine()*/
    /*@Pointcut("execution(* spring.aop.Library.*())")
    private void allMethodsFromLibrary(){}

    @Pointcut("execution(* spring.aop.Library.returnMagazine())")
    private void returnMagazineMethodFromLibrary(){}

    @Pointcut("allMethodsFromLibrary() && ! returnMagazineMethodFromLibrary()")
    private void allMethodsExceptFromLibrary(){}

    @Before("allMethodsExceptFromLibrary()")
    private void beforeAllMethodsExceptLoggingAspect(){
        System.out.println("beforeAllMethodsExceptLoggingAspect: writing Log #10");
    }*/

    /** Комбинированный Pointcut #1*/
    /*@Pointcut("execution(* spring.aop.Library.get*())")
    private void allGetMethodsFromLibrary(){}

    @Pointcut("execution(* spring.aop.Library.return*())")
    private void allReturnMethodsFromLibrary(){}

    @Pointcut("allGetMethodsFromLibrary() || allReturnMethodsFromLibrary()")
    private void allGetAndReturnMethodsFromLibrary(){}

    @Before("allGetMethodsFromLibrary()")
    public void beforeGetLoggingAspect(){
        System.out.println("beforeGetLoggingAspect: writing Log #1");
    }

    @Before("allReturnMethodsFromLibrary()")
    public void beforeReturnLoggingAspect(){
        System.out.println("beforeReturnLoggingAspect: writing Log #2");
    }

    @Before("allGetAndReturnMethodsFromLibrary()")
    public void beforeGetAndReturnLoggingAspect(){
        System.out.println("beforeGetAndReturnLoggingAspect: writing Log #3");
    }*/


    /** Pointcut объявленый отдельным методом*/
    /*@Pointcut("execution(* return*())")
    private void allReturnMethodFromLibrary(){}

    @Before("allReturnMethodFromLibrary()")
    public void beforeReturnBookLoggingAspect(){
        System.out.println("beforeReturnBookLoggingAspect: попытка вернуть книгу/журнал в библиотеку");
    }*/


    /** Pointcut объявленый вручную в @Before*/
    /*@Before("execution(public void getBook())")
    public void beforeGetBookLoggingAspect(){
        System.out.println("beforeGetBookLoggingAspect: попытка взять книгу из библиотеки");
    }

    @Before("execution(public void getMagazine())")
    public void beforeGetMagazineLoggingAspect(){
        System.out.println("beforeGetMagazineLoggingAspect: попытка взять журнал из библиотеки");
    }*/

}
