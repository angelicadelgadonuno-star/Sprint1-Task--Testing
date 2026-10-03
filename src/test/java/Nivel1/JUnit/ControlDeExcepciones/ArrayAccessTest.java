package Nivel1.JUnit.ControlDeExcepciones;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ArrayAccessTest {

    @ParameterizedTest(name = "Position {0} -> {1}")
    @CsvSource({
            "0, Doll",
            "1, Robot",
            "2, Ball"
    })
    void getToyByPosition_validPosition_returnsExpectedToy(int position, String expectedToy) {
        assertEquals(expectedToy, ArrayAccess.getToyByPosition(position));
    }

    @ParameterizedTest(name = "Position {0} -> exception")
    @ValueSource(ints = {-1, 3, 100})
    void getToyByPosition_invalidPosition_throwsArrayIndexOutOfBoundsException(int position) {
        try {
            ArrayAccess.getToyByPosition(position);
            fail("Expected ArrayIndexOutOfBoundsException for " + position);
        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }

}