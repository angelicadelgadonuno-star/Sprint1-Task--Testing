package Nivel2.AssertJ;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;

public class Ejercicio4Test {
    private String toy;
    private Integer age;
    private Double price;
    private Boolean question;
    private ArrayList<Object> objects;

    @BeforeEach
    void setUp(){
        toy = "Doll";
        age = 44;
        price = 14.99;
        question = false;
        objects = new ArrayList<>();
        objects.add(toy);
        objects.add(age);
        objects.add(price);
    }

    @Test
    void list_insertedObjects_keepsInsertionOrder(){
        assertThat(objects).containsExactly(toy, age, price);
    }

    @Test
    void list_insertedObjects_containsAllInAnyOrder() {
        assertThat(objects).containsExactlyInAnyOrder(price, toy, age);
    }

    @Test
    void list_insertedObject_appearsOnlyOnce() {
        assertThat(objects).containsOnlyOnce(toy);
    }

    @Test
    void list_notInsertedObject_isNotContained() {
        assertThat(objects).doesNotContain(question);
    }
}
