package ru.na.geometry.figures;

public record Rectangle(double a, double b) {

    public Rectangle {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Rectangle side should be non-negative");
        }
    }

    public static void printRectangleArea(double a, double b) {
        var text = String.format("Площадь прямоугольника со сторонами %f и %f = %f ", a, b, rectangleArea(a, b));
        System.out.println(text);

    }

    private static double rectangleArea(double a, double b) {
        return a * b;
    }
}
