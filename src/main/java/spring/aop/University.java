package spring.aop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class University {

    private List<Student> students = new ArrayList<>();

    public void addStudent(){

        Student st1 = new Student("Student1", 3, 4.5);
        Student st2 = new Student("Student2", 5, 3.6);
        Student st3 = new Student("Student3", 2, 4.8);

        students.add(st1);
        students.add(st2);
        students.add(st3);

    }

    public List<Student> getStudents(){
        System.out.println("Start method");
//        System.out.println(students.get(3));
        System.out.println("Information from method getStudents()");
        return students;
    }

}
