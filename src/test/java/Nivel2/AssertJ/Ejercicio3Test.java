package Nivel2.AssertJ;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class Ejercicio3Test {

    @Test
    void intArrays_sameContent_areIdentical() {
        int[] one = {2, 4, 6, 8};
        int[] two = {2, 4, 6, 8};
        assertThat(one).isEqualTo(two);
    }
}
