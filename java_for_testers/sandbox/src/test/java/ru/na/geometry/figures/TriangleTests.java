package ru.na.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void cantCalculatePerimeter() {
        Assertions.assertEquals(42.0, new Triangle(13.0, 14.0, 15.0).perimeter());
    }

    @Test
    void cantCalculateSemiperimeter() {
        Assertions.assertEquals(21.0, new Triangle(13.0, 14.0, 15.0).semiperimeter());
    }

    @Test
    void cantCalculateArea() {
        Assertions.assertEquals(84.0, new Triangle(13.0, 14.0, 15.0).area());
    }

    @Test
    void cannotCreateTriangleWithNegativeSide() {
        try {
            new Triangle(-13.0, 14.0, 15.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //OK
        }
    }

    @Test
    void testEquality() {
        var g1 = new Triangle(13.0, 14.0, 15.0);
        var g2 = new Triangle(14.0, 15.0, 13.0);
        Assertions.assertEquals(g1, g2);
    }

    @Test
    void testEquality2() {
        var g1 = new Triangle(13.0, 14.0, 15.0);
        var g3 = new Triangle(15.0, 13.0, 14.0);
        Assertions.assertEquals(g1, g3);
    }

    @Test
    void testEquality3() {
        var g2 = new Triangle(14.0, 15.0, 13.0);
        var g3 = new Triangle(15.0, 13.0, 14.0);
        Assertions.assertEquals(g2, g3);
    }
}





