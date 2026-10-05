package Nivel2.AssertJ;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;;

public class Ejercicio5Test {

    @Test
    void mapContainsKey (){

        Map<String, Integer> members = new HashMap<>();
        members.put("Arturo", 55);
        members.put("Sandra", 25);
        members.put("Gerardo",78);
        assertThat(members).containsKey("Sandra");
    }
}
