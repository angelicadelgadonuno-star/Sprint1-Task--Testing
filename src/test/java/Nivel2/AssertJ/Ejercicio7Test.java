package Nivel2.AssertJ;

import java.util.Optional;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Ejercicio7Test {

    @Test
    void optional_empty_isEmpty() {
        Optional<String> box = Optional.empty();
        assertThat(box).isEmpty();
    }
}
