package org.example.interview.interviewexample.sealedClass;

// Permitted subclass: non-sealed (allows unrestricted inheritance)
public non-sealed class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side * side;
    }
}