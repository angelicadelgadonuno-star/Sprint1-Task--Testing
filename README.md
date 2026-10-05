# Task 4: Testing in Java (JUnit 5 and AssertJ)

This project is a set of exercises about automated testing in Java. It uses JUnit 5 and AssertJ to check the behaviour of simple classes.

```

## Project structure

```
src/main/java
  Nivel1/JUnit/TestsUnitariosConJUnit   -> Book, LibraryManagement
  Nivel1/JUnit/TestParametritzat        -> CalculoDni
  Nivel1/JUnit/ControlDeExcepciones     -> ArrayAccess
  Nivel2/AssertJ                        -> Ejercicio6

src/test/java
  Nivel1/JUnit/TestsUnitariosConJUnit   -> LibraryManagementTest
  Nivel1/JUnit/TestParametritzat        -> CalculoDniTest
  Nivel1/JUnit/ControlDeExcepciones     -> ArrayAccessTest
  Nivel2/AssertJ                        -> Ejercicio1Test ... Ejercicio7Test
```

The course rules do not allow comments in the code, so the design decisions are explained in this file.

---

## Level 1: JUnit

### Exercise 1: Unit tests with JUnit (library books)

**Classes:** `Book` and `LibraryManagement` (package `Nivel1.JUnit.TestsUnitariosConJUnit`)

- `Book` has a title. `equals` and `hashCode` use the title, so two books with the same title are equal. It implements `Comparable`, so books can be sorted alphabetically.
- `LibraryManagement` keeps the books in a list, in insertion order:
    - `addBook(Book)` adds a book at the end.
    - `addBookAt(int, Book)` adds a book at a given position.
    - `getBooks()` returns a copy of the list.
    - `getTitleAt(int)` returns the title of the book at a position.
    - `removeBookByTitle(String)` removes the book with that title.
    - `getSortedBooks()` returns a sorted copy, so the original list does not change.

Design decisions:

- Duplicate titles are not allowed. `addBook` and `addBookAt` throw an `IllegalArgumentException` if the book is already in the collection.
- `getBooks()` and `getSortedBooks()` return copies, so the internal list cannot be changed from outside.

**Test class:** `LibraryManagementTest`

A new `LibraryManagement` is created before each test with `@BeforeEach`.

| Required case | Test |
|---|---|
| The collection is not null after creating the class | `collectionIsNotNullAfterInstantiation` |
| The size is correct after adding several books | `sizeIsOneAfterAddingOneBook`, `sizeIsCorrectAfterAddingSeveralBooks` |
| The books are in the expected position | `booksAreInExpectedPositionAfterAdding` |
| Get the title by position | `getTitleAtReturnsCorrectTitle` |
| Add a book at a specific position | `insertsBookInSpecificPlace` |
| Remove a book by title reduces the size | `removeBookByTitle` |
| The sorted list is alphabetical and the original does not change | `sortedListIsAlphabeticalAndDoesNotModifyOriginal` |
| Duplicate titles are not allowed | `duplicateTitlesAreNotAllowed`, `duplicateTitlesAreNotAllowedWhenAddingAtPosition` |

The duplicate tests use `try/catch` with `fail(...)`, because lambdas have not been studied yet. They also check that the size does not change after the error.

### Exercise 2: Parameterized test (DNI letter)

**Class:** `CalculoDni` (package `Nivel1.JUnit.TestParametritzat`)

The method `calculateDniLetter(int dniNumber)` is static. It returns the letter of a DNI:

1. It takes the remainder of the number divided by 23 (the length of the letters string).
2. It uses that remainder as a position in the string `TRWAGMYFPDXBNJZSQVHLCKE`.

Design decisions:

- Valid range: from 0 to 99999999.
- The number 0 is valid and gives the letter `T`.
- Numbers outside the range throw an `IllegalArgumentException` with a message that shows the limit.
- The validation is done first (fail fast), before the calculation.

**Test class:** `CalculoDniTest`

| Test | Source | Cases |
|---|---|---|
| Valid numbers return the expected letter | `@CsvSource` | 13 |
| Numbers out of range throw the exception | `@ValueSource` | 4 (`-1`, `-12345678`, `100000000`, `Integer.MAX_VALUE`) |

The valid cases include the limits (0 and 99999999) and the changes of the modulo cycle (22, 23, 24). The exception test uses `try/catch` with `fail(...)` because lambdas have not been studied yet.

**Breaking tests on purpose:**

- I changed `DNI_MAX` to `99999998`. The case `99999999` failed with an unexpected `IllegalArgumentException`.
- I changed one expected letter in the CSV data. The test failed with an `AssertionFailedError` that showed the expected and the actual letter. In that case the wrong value was in the test data, not in the code.

### Exercise 3: Exception control

**Class:** `ArrayAccess` (package `Nivel1.JUnit.ControlDeExcepciones`)

The method `getToyByPosition(int position)` returns an element of a fixed array of 3 toys. It has no `throw` and no validation, so Java itself throws `ArrayIndexOutOfBoundsException` when the position does not exist.

**Test class:** `ArrayAccessTest`

| Test | Source | Cases |
|---|---|---|
| Valid position returns the expected toy | `@CsvSource` | 0, 1, 2 |
| Invalid position throws `ArrayIndexOutOfBoundsException` | `@ValueSource` | -1, 3, 100 |

The test catches the specific exception, not the generic `Exception`.

---

## Level 2: AssertJ

Each exercise has its own test class in the package `Nivel2.AssertJ`. Exercise 6 also needs a support class.

| Exercise | Class | What it shows | AssertJ methods |
|---|---|---|---|
| 1 | `Ejercicio1Test` | Two `Integer` objects with equal value, and with different value | `isEqualTo`, `isNotEqualTo` |
| 2 | `Ejercicio2Test` | Same reference and different reference of an `Object` | `isSameAs`, `isNotSameAs` |
| 3 | `Ejercicio3Test` | Two `int[]` arrays with identical content | `isEqualTo` |
| 4 | `Ejercicio4Test` | `ArrayList` with different types of objects | `containsExactly`, `containsExactlyInAnyOrder`, `containsOnlyOnce`, `doesNotContain` |
| 5 | `Ejercicio5Test` | A `Map` contains a key | `containsKey`, `containsEntry` |
| 6 | `Ejercicio6` and `Ejercicio6Test` | `ArrayIndexOutOfBoundsException` is thrown when it should be | `isInstanceOf`, `failBecauseExceptionWasNotThrown` |
| 7 | `Ejercicio7Test` | An empty `Optional` | `isEmpty` |


