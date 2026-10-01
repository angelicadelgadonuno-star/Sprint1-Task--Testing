package Nivel1.JUnit.TestParametritzat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CalculoDniTest {

    @ParameterizedTest(name = "DNI {0} -> {1}")
    @CsvSource({
        "12345678, Z",
        "1, R",
        "0, T",
        "22, E",
        "23, T",
        "24, R",
        "50, G",
        "10000000, Z",
        "11111111, H",
        "12345679, S",
        "40000000, X",
        "87654321, X",
        "99999999, R"})
    void calculateDniLetter_validNumber_returnsExpectedLetter(int number,char expectedLetter) {
        assertEquals(expectedLetter, CalculoDni.calculateDniLetter(number));
    }

    @ParameterizedTest(name = "DNI {0} -> exception")
    @ValueSource(ints = {-1, -12345678, 100000000, 2147483647})
    void calculateDniLetter_numberOutOfRange_throwsIllegalArgumentException(int number){
      try {
          CalculoDni.calculateDniLetter(number);
          fail("Expected IllegalArgumentException for " + number);
      } catch (IllegalArgumentException e){
      }
    }
}

