package Nivel2.AssertJ;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;

public class Ejercicio6Test {

    @Test
    void colors_invalidPosition_throwsArrayIndexOutOfBounds() {
        try {
            Ejercicio6.getColorAt(3 );
            failBecauseExceptionWasNotThrown(ArrayIndexOutOfBoundsException.class);
        } catch (ArrayIndexOutOfBoundsException e) {
            assertThat(e).isInstanceOf(ArrayIndexOutOfBoundsException.class);
        }
    }

    @Test
    void colors_validPosition_returnsExpectedColor() {
        assertThat(Ejercicio6.getColorAt(0)).isEqualTo("Blue");
    }

}
