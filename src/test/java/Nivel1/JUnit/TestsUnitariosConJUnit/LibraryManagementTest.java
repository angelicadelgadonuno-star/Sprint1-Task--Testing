package Nivel1.JUnit.TestsUnitariosConJUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
