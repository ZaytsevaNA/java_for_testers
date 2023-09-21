package ru.na.geometry.figures;

import static java.lang.Math.sqrt;

public record Triangle(double x, double y, double z) {

    public static void printTriangleePerimeter(Triangle t) {
        var text = String.format("Стороны %f, %f, %f, периметр %f, полупериметр %f, площадь %f: треугольника", t.x, t.y, t.z, t.perimeter(), t.semiperimeter(), t.area());
        System.out.println(text);
    }

    public double perimeter() {
        return this.x + this.y + this.z;
    }

    public double semiperimeter() {
        return (this.x + this.y + this.z) / 2;
    }

    public double area() {
        var p = semiperimeter();
        return sqrt(p * (p - this.x) * (p - this.y) * (p - this.z));
    }
}

