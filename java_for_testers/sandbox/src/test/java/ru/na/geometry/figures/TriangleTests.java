package ru.na.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void cantCalculatePerimeter(){
        Assertions.assertEquals(42.0, new Triangle(13.0, 14.0, 15.0).perimeter());
    }

    @Test
    void cantCalculateSemiperimeter(){
        Assertions.assertEquals(21.0, new Triangle(13.0, 14.0, 15.0).semiperimeter());
    }

    @Test
    void cantCalculateArea(){
        Assertions.assertEquals(84.0, new Triangle(13.0, 14.0, 15.0).area());
    }
}





