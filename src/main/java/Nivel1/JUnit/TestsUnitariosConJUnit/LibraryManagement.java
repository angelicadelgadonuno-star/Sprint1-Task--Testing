package Nivel1.JUnit.TestsUnitariosConJUnit;

import java.util.ArrayList;
import java.util.List;

public class LibraryManagement {

    private final List<Book> books = new ArrayList<>();

    public void addBook (Book book) {
       this.books.add(book);
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }
    /*books.add(new Book("Flesh"));
        books.add(new Book("The Loneliness of Sonia and Sunny"));
        books.add(new Book("One Hundred Years Of Solitude"));
        books.add(new Book("Naked Lunch"));*/


}
