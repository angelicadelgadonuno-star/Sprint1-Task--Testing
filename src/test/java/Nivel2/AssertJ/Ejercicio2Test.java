package Nivel2.AssertJ;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Ejercicio2Test {

    @Test
    void objects_sameReference_areSame() {
        Object object1 = new Object();
        Object object2 = object1;
        assertThat(object1).isSameAs(object2);
    }

    @Test
    void objects_differentReferences_areNotSame() {
        Object object1 = new Object();
        Object object2 = new Object();
        assertThat(object1).isNotSameAs(object2);
    }
}
