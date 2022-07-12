package spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class SecurityAspect {

    @Before("spring.aop.aspect.MyPointcuts.addMethodsFromLibrary()")
    public void beforeAddMethodsSecurityAspect(){
        System.out.println("beforeAddMethodsSecurityAspect: проверка прав на получение книги/журнала");
    }

}
