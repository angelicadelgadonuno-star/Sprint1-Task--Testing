package Nivel2.AssertJ;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Ejercicio1Test {

    @Test
    void integers_sameValue_areEqual() {
        Integer firstValue = 20;
        Integer secondValue = 20;
        assertThat(firstValue).isEqualTo(secondValue);
    }


}

