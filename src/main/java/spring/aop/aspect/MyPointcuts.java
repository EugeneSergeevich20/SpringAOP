package spring.aop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {

    @Pointcut("execution(* spring.aop.Library.add*(..))")
    public void addMethodsFromLibrary(){}

}
