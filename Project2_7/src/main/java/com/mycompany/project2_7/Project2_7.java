package com.mycompany.project2_7;

import java.util.Scanner;
import java.util.InputMismatchException;

// Point class for working with points on the plane
class Point {
    private double x;
    private double y;

    // Default constructor
    public Point() {
        this.x = 0.0;
        this.y = 0.0;
    }

//    // Parameterized constructor
//    public Point(double x, double y) {
//        this.x = x;
//        this.y = y;
//    }
    
    public void init(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public void read() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter x coordinate:");
        this.x = readDouble(scanner);
        
        System.out.println("Enter y coordinate:");
        this.y = readDouble(scanner);
    }

    private double readDouble(Scanner scanner) {
        boolean validInput = false;
        double value = 0.0;
        
        while (!validInput) {
            try {
                value = scanner.nextDouble();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter a number.");
                scanner.next(); // Clear scanner buffer
            }
        }
        return value;
    }

    public void display() {
        System.out.println("Point: (" + this.x + ", " + this.y + ")");
    }
    
     // Calculate distance 
    public double distanceTosymmetricRelativeOY() {
        return 2 * Math.abs(this.y);
    }
    
    
    // Method for adding points (adding corresponding coordinates)
    public static Point add(Point a, Point b) {
        Point c = new Point();
        c.init(a.getX() + b.getX(), a.getY() + b.getY());
        return c;
    }

    // Getters and setters
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}

// Demo class for testing
public class Project2_7 {
    public static void main(String[] args) {
        // Testing Point class
        System.out.println("=== Testing Point class ===");
        
        Point p1 = new Point();
        Point p2 = new Point();
        
        System.out.println("Enter data for point p1:");
        p1.read();
        
        System.out.println("\nPoint p1:");
        p1.display();
        
        System.out.println("Enter data for point p2:");
        p2.read();
            
        System.out.println("\nPoint p2:");
        p2.display();
        
        // Calculate distance between points
        double distance = p1.distanceTosymmetricRelativeOY();
        System.out.println("\nDistance between p1 and p2: " + distance);
        
        // Add points
        Point sum = Point.add(p1,p2);
        System.out.println("Sum of points p1 and p2:");
        sum.display();
        
    }
}
