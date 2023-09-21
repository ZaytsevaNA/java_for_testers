package ru.na.geometry;

import ru.na.geometry.figures.Rectangle;
import ru.na.geometry.figures.Square;
import ru.na.geometry.figures.Triangle;

public class Geometry {
    public static void main(String[] args) {
        Square.printSquareArea(new Square(7.0));
        Square.printSquareArea(new Square(5.0));
        Square.printSquareArea(new Square(3.0));

        Rectangle.printRectangleArea(3.0, 5.0);
        Rectangle.printRectangleArea(7.0, 9.0);

        Triangle.printTriangleePerimeter(new Triangle(13.0, 14.0, 15.0));
    }
}

