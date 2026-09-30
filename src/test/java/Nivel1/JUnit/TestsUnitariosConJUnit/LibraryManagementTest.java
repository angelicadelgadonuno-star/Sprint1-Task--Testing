package Nivel1.JUnit.TestsUnitariosConJUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LibraryManagementTest {

    private LibraryManagement library;

    @BeforeEach
    void setUp(){
        library = new LibraryManagement();
    }

    @Test
    void collectionIsNotNullAfterInstantiation(){
        assertNotNull(library.getBooks());
    }

    @Test
    void sizeIsOneAfterAddingOneBook(){
        library.addBook(new Book("Flesh"));
        assertEquals(1, library.getBooks().size());
    }

    @Test
    void getTitleAtReturnsCorrectTitle(){
        library.addBook(new Book("One Hundred Years Of Solitude"));
        library.addBook(new Book("Naked Lunch"));
        assertEquals("Naked Lunch", library.getTitleAt(1));
    }

    @Test
    void insertsBookInSpecificPlace(){
        library.addBook(new Book("One Hundred Years Of Solitude"));
        library.addBook(new Book("Naked Lunch"));
        library.addBookAt(1, new Book ("The Loneliness of Sonia and Sunny"));
        assertEquals("The Loneliness of Sonia and Sunny", library.getTitleAt(1));
        assertEquals(3, library.getBooks().size());
    }

    @Test
    void removeBookByTitle(){
        library.addBook(new Book("Somebody Flew Over the Cuckoo's Nest"));
        library.addBook(new Book("Black is Beltza"));
        library.removeBookByTitle("Black is Beltza");
        assertEquals(1, library.getBooks().size());
        assertEquals("Somebody Flew Over the Cuckoo's Nest", library.getTitleAt(0));
    }

    @Test
    void sortedListIsAlphabeticalAndDoesNotModifyOriginal(){
        library.addBook(new Book("Somebody Flew Over The Cuckoo's Nest"));
        library.addBook(new Book("Black Is Beltza"));
        library.addBook(new Book("One Hundred Years Of Solitude"));
        library.addBook(new Book("Naked Lunch"));
        library.addBook(new Book("Flesh"));
        assertEquals(List.of(new Book("Black Is Beltza"), new Book("Flesh"),
                new Book("Naked Lunch"), new Book("One Hundred Years Of Solitude"),
                new Book("Somebody Flew Over The Cuckoo's Nest")), library.getSortedBooks());
        assertEquals("Somebody Flew Over The Cuckoo's Nest", library.getTitleAt(0));
    }

    @Test
    void sizeIsCorrectAfterAddingSeveralBooks(){
        library.addBook(new Book("Dune"));
        library.addBook(new Book("Rayuela"));
        library.addBook(new Book("I Want To Be Awake When I Die"));
        library.addBook(new Book("The Handmaid´s Tale"));
        assertEquals(4, library.getBooks().size());
    }




}
