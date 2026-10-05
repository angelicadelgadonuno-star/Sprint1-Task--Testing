package Nivel1.JUnit.TestsUnitariosConJUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class LibraryManagementTest {

    private LibraryManagement library;

    @BeforeEach
    void setUp() {
        library = new LibraryManagement();
    }

    private void addBooks(List<String> titles) {
        for (String title : titles) {
            library.addBook(new Book(title));
        }
    }

    @Test
    void collectionIsNotNullAfterInstantiation() {
        assertNotNull(library.getBooks());
    }

    @Test
    void sizeIsOneAfterAddingOneBook() {
        library.addBook(new Book("Flesh"));
        assertEquals(1, library.getBooks().size());
    }

    @Test
    void getTitleAtReturnsCorrectTitle() {
        addBooks(List.of("One Hundred Years Of Solitude", "Naked Lunch"));
        assertEquals("Naked Lunch", library.getTitleAt(1));
    }

    @Test
    void insertsBookInSpecificPlace() {
        addBooks(List.of("One Hundred Years Of Solitude", "Naked Lunch"));
        library.addBookAt(1, new Book("The Loneliness of Sonia and Sunny"));
        assertEquals("The Loneliness of Sonia and Sunny", library.getTitleAt(1));
        assertEquals(3, library.getBooks().size());
    }

    @Test
    void removeBookByTitle() {
        addBooks(List.of("Somebody Flew Over the Cuckoo's Nest", "Black is Beltza"));
        library.removeBookByTitle("Black is Beltza");
        assertEquals(1, library.getBooks().size());
        assertEquals("Somebody Flew Over the Cuckoo's Nest", library.getTitleAt(0));
    }

    @Test
    void sortedListIsAlphabeticalAndDoesNotModifyOriginal() {
        addBooks(List.of("Somebody Flew Over The Cuckoo's Nest", "Black Is Beltza", "One Hundred Years Of Solitude", "Naked Lunch", "Flesh"));
        assertEquals(List.of(new Book("Black Is Beltza"), new Book("Flesh"),
                new Book("Naked Lunch"), new Book("One Hundred Years Of Solitude"),
                new Book("Somebody Flew Over The Cuckoo's Nest")), library.getSortedBooks());
        assertEquals("Somebody Flew Over The Cuckoo's Nest", library.getTitleAt(0));
    }

    @Test
    void sizeIsCorrectAfterAddingSeveralBooks() {
        addBooks(List.of("Dune", "Rayuela", "I Want To Be Awake When I Die", "The Handmaid's Tale"));
        assertEquals(4, library.getBooks().size());
    }

    @Test
    void booksAreInExpectedPositionAfterAdding() {
        addBooks(List.of("Dune", "Rayuela", "I Want To Be Awake When I Die"));
        assertEquals(List.of(new Book("Dune"), new Book("Rayuela"),
                new Book("I Want To Be Awake When I Die")), library.getBooks());
    }

    @Test
    void duplicateTitlesAreNotAllowed() {
        library.addBook(new Book("Flesh"));
        try {
            library.addBook(new Book("Flesh"));
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals(1, library.getBooks().size());
        }
    }

    @Test
    void duplicateTitlesAreNotAllowedWhenAddingAtPosition() {
        library.addBook(new Book("Flesh"));
        try {
            library.addBookAt(0, new Book("Flesh"));
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals(1, library.getBooks().size());
        }
    }
}



