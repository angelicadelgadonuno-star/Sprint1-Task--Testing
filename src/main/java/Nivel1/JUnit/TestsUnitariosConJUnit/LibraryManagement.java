package Nivel1.JUnit.TestsUnitariosConJUnit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LibraryManagement {

    private final List<Book> books = new ArrayList<>();

    public void addBook (Book book) {
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
        this.books.add(position, book);
    }

    public void removeBookAt(String bookName) {
        for (int i = books.size() -1; i >=0; --i){
            if (books.get(i).getBookName().equals(bookName)){
                books.remove(i);
            }
        }
    }
}
