package spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import spring.aop.Student;
import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {

    /**@Before выполняется до начала метода с основной логикой*/
    @Before("execution(* getStudents())")
    public void beforeGetStudentLoggingAspect(){
        System.out.println("beforeGetStudentLoggingAspect: логируем получение " +
                "списка студентов перед методом getStudents()");
    }

    /**@AfterReturning выполняется после нормального окончания метода с основной логикой,
     * но до присвоения результата этого метода какой-либо переменной.
     * Поэтому с помошью @AfterReturning возможно изменять возвращаемый результат метода*/
    @AfterReturning(pointcut = "execution(* getStudents())"
            , returning = "students")
    public void afterReturningGetStudentsLoggingAspect(JoinPoint joinPoint, List<Student> students){

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("-----------------------------------------------------");
        System.out.println("methodSignature - " + methodSignature);
        System.out.println("methodSignature.getMethod() - " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType() - " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName() - " + methodSignature.getName());
        System.out.println("-----------------------------------------------------");

        Student firstStudent = students.get(0);
        String nameSurname = firstStudent.getNameSurname();
        nameSurname = "Mr. " + nameSurname;
        firstStudent.setNameSurname(nameSurname);

        double avgGrade = firstStudent.getAvgGrade();
        avgGrade = avgGrade + 1.7;
        firstStudent.setAvgGrade(avgGrade);

        System.out.println("afterReturningGetStudentsLoggingAspect: логируем получение " +
                "списка студентов после работы метода getStudents()");

    }


    /**@AfterThrowing выполняется после окончания работы метода с основной логикой,
     * не влияет на протикание программы при выбрасывании исключения.
     * С помощью @AfterThrowing можно получить доступ к исключению, которое
     * выбросилось из метода с основной логикой*/
    @AfterThrowing(pointcut = "execution(* getStudents())"
            , throwing = "exception")
    public void afterTrowingGetStudentLoggingAspect(Throwable exception){
        System.out.println("afterTrowingGetStudentLoggingAspect: логирем выброс исключения - " + exception);
    }

    /**@After выполняется после окончания работы метода с основной логикой
     * вне зависимости от того, завершается ли метод нормально или выбрасывается исключение
     * С помощью @After невозможно:
     * -получить доступ к исключение, которое выбросилось из метода с основной логикой
     * -получить доступ к возвращаемому методом результату*/
    @After("execution(* getStudents())")
    public void afterGetStudentLoggingAspect(){
        System.out.println("afterGetStudentsLoggingAdvice: логируем нормальное окончание метода или выброс исключения");
    }

}
