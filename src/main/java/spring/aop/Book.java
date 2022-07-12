package spring.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {

    @Value("NameBook")
    private String nameBook;

    @Value("Author")
    private String author;

    @Value("2022")
    private int yearOfPublication;

    public String getNameBook() {
        return nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }
}
