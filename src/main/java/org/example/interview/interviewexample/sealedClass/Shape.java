package org.example.interview.interviewexample.sealedClass;

// Parent sealed class
public sealed abstract class Shape permits Circle, Square {
    public abstract double area(); // Abstract method for area calculation
}







