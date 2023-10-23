package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CollectionTests {

    @Test
    void arrayTests() {
        var array = new String[]{"a", "b", "c"};
        Assertions.assertEquals(3, array.length);
        Assertions.assertEquals("a", array[0]);

        array[0] = "b";
        Assertions.assertEquals("b", array[0]);
    }

    @Test
    void listTests() {
        var list = new ArrayList<>(List.of("a", "b", "c"));
        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals("a", list.get(0));

        list.set(0, "d");
        Assertions.assertEquals("d", list.get(0));
    }
}
