package Nivel1.JUnit.TestsUnitariosConJUnit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LibraryManagement {

    private final List<Book> books = new ArrayList<>();

    public void addBook (Book book) {
       if(this.books.contains(book)){
           throw new IllegalArgumentException("ERROR: That Book Title is already in our database");
       }
        this.books.add(book);
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public String getTitleAt(int i) {
       Book book = books.get(i);
        return book.getBookName();
   }

    public void addBookAt(int position, Book book) {
        if(this.books.contains(book)){
            throw new IllegalArgumentException("ERROR: That Book Title is already in our database");
        }
        this.books.add(position, book);
    }

    public void removeBookByTitle (String bookName) {
        for (int i = books.size() -1; i >=0; --i){
            if (books.get(i).getBookName().equals(bookName)){
                books.remove(i);
            }
        }
    }

    public List<Book> getSortedBooks() {
        List<Book> sortedBooks = new ArrayList<>(books);
        Collections.sort(sortedBooks);
        return sortedBooks;
    }
}
