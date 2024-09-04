package JavaOOPS;

public class Main {
    public static void main(String[] args) {
        
        User user = new User("Ace of Spades", "2002-10-06");

        Book book = new Book("Harry Potter", "J K Rowling", 300);

        AudioBook audioBook = new AudioBook("Percy Jackson", "Rick Riordian", 30080);

        Ebook ebook = new Ebook("Nature Stories", "Ruskin bond", 560, "pdf");

        user.borrow(book);

        System.out.printf(ebook.toString());
       
    }
}
