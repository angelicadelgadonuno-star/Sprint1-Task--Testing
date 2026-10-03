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

    @Test
    void integers_differentValues_areNotEqual() {
        Integer firstValue = 125;
        Integer secondValue = 130;
        assertThat(firstValue).isNotEqualTo(secondValue);
    }



}

