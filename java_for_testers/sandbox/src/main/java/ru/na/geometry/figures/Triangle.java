package ru.na.geometry.figures;

import static java.lang.Math.sqrt;

public record Triangle(double x, double y, double z) {

    public Triangle {
        if (x < 0 || y < 0 || z < 0 || x + y > z || x + z > y || y + z > x) {
            throw new IllegalArgumentException("Triangle side should be non-negative or the sum of any two parties must be at least the third party");
        }
    }

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

