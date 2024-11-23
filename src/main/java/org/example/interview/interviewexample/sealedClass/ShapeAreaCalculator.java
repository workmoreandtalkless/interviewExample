package org.example.interview.interviewexample.sealedClass;

//public class ShapeAreaCalculator {
//    public static void main(String[] args) {
//        Shape shape = new Circle(5);
//
//        String result = switch (shape) {
//            case Circle c -> "Circle area: " + c.area();
//            case Square s -> "Square area: " + s.area();
//            default -> throw new IllegalStateException("Unexpected shape: " + shape);
//        };
//
//        System.out.println(result);
//    }
//}

public class ShapeAreaCalculator {
    public static void main(String[] args) {
        Shape shape = new Circle(5);

        if (shape instanceof Circle c) {
            System.out.println("Circle area: " + c.area());
        } else if (shape instanceof Square s) {
            System.out.println("Square area: " + s.area());
        } else {
            throw new IllegalStateException("Unexpected shape: " + shape);
        }
    }
}


