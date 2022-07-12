package spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {

    /**@Around выполняется до и после метода с основной логикой
     * С помощью @Around Advice возможно:
     * -произвести какие-либо действия до работы target метода;
     * -произвести какие-либо действия после работы target метода;
     * -получить результат работы target метода/изменить его;
     * -предпринять какие-либо действия, если из target метода выбрасывается исключение.*/
    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("aroundReturnBookLoggingAspect: в библиотеку " +
                "пытаются вернуть книгу");

        long begin = System.currentTimeMillis();

        Object targetMethodResult = null;

        try {
            targetMethodResult = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println("aroundReturnBookLoggingAspect: было поймано исключение " + e);
//            targetMethodResult ="Error name book";
            throw e;
        }

//        targetMethodResult = "newBook";

        long end = System.currentTimeMillis();

        System.out.println("aroundReturnBookLoggingAspect: в библиотеку " +
                "успешно возвращаем книгу");

        System.out.println("aroundReturnBookLoggingAspect: метод returnBook " +
                "выполнил свою работа за " + (end - begin) + " мс");

        return targetMethodResult;
    }

}
