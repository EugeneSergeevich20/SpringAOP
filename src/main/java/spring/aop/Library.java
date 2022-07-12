package spring.aop;

import org.springframework.stereotype.Component;

@Component
public class Library {

    public void getBook(){
        System.out.println("Мы берём книгу из библиотеки");
        System.out.println("-----------------------------------------------------------");
    }

    public String returnBook(){
        int a = 10/0;
        System.out.println("Мы возвращаем книгу в библиотеку");
        System.out.println("-----------------------------------------------------------");
        return "Name book";
    }

    public void addBook(String personName, Book book){
        System.out.println("Мы добавляем книгу в библиотеку");
        System.out.println("-----------------------------------------------------------");;
    }

    public void getMagazine(){
        System.out.println("Мы берём журнал из библиотеки");
        System.out.println("-----------------------------------------------------------");
    }

    public void returnMagazine(){
        System.out.println("Мы возвращаем журнал в библиотеку");
        System.out.println("-----------------------------------------------------------");
    }

    public void addMagazine(){
        System.out.println("Мы добавляем журнал в библиотеку");
        System.out.println("-----------------------------------------------------------");
    }

}
