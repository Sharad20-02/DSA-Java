package JavaOOPS;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class User {
    private String name;
    private LocalDate birthDay;
    private ArrayList<Book> books = new ArrayList<Book>();

    User(String name, String birthDay){
        this.name = name;
        this.birthDay = LocalDate.parse(birthDay);
    }

    public int age(){
        Period age = Period.between(this.birthDay, LocalDate.now());
        return age.getYears();
    }

    public void borrow(Book book){
        this.books.add(book);
    }

    public String getName(){
        return this.name;
    }

    public String getBirthDay(){
        return this.birthDay.toString();
    }

    public String getBorrowedBooks(){
        return this.books.toString();
    }
}
