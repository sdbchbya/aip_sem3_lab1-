package com.mycompany.project4_7;

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


// Record for working with points on the plane
record PointRecord(double x, double y) {
    
    // Static method for creating a point through user input
    public static PointRecord readFromInput() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter x coordinate:");
        double x = readDouble(scanner);
        
        System.out.println("Enter y coordinate:");
        double y = readDouble(scanner);
        
        return new PointRecord(x, y);
    }

    private static double readDouble(Scanner scanner) {
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
        System.out.println("PointRecord: (" + this.x + ", " + this.y + ")");
    }

   // Calculate distance 
    public double distanceTosymmetricRelativeOY() {
        return 2 * Math.abs(this.y);
    }

    // Method for adding points (adding corresponding coordinates)
    public static PointRecord add(PointRecord a, PointRecord b) {
        return new PointRecord(a.x + b.x, a.y + b.y);
    }
}

// Demo class for testing both implementations
public class Project4_7 {
    public static void main(String[] args) {
        System.out.println("=== CLASS VS RECORD COMPARISON ===");
        
        // Demonstration of working with class
        System.out.println("\n--- WORKING WITH Point CLASS ---");
        Point p1 = new Point();
        p1.init(2, 3);
        Point p2 = new Point();
        p2.init(4, 8);
        
        System.out.println("\nBefore Point p2 = p1:");
        System.out.print("p1: "); p1.display();
        System.out.print("p2: "); p2.display();
        
        p2 = p1; // Reference assignment
        
        System.out.println("\nAfter Point p2 = p1:");
        System.out.print("p1: "); p1.display();
        System.out.print("p2: "); p2.display();
        
        // Modify p1 using setter
        p1.setX(10);
        System.out.println("\nAfter p1.setX(10):");
        System.out.print("p1: "); p1.display();
        System.out.print("p2: "); p2.display();
        System.out.println("p1 == p2: " + (p1 == p2));
        System.out.println("p1.equals(p2): " + p1.equals(p2));
        
        // Demonstration of working with record
        System.out.println("\n--- WORKING WITH PointRecord RECORD ---");
        PointRecord pr1 = new PointRecord(2, 3);
        PointRecord pr2 = new PointRecord(4, 5);
        
        System.out.println("\nBefore PointRecord pr2 = pr1:");
        System.out.print("pr1: "); pr1.display();
        System.out.print("pr2: "); pr2.display();
        
        pr2 = pr1; // Reference assignment
        
        System.out.println("\nAfter PointRecord pr2 = pr1:");
        System.out.print("pr1: "); pr1.display();
        System.out.print("pr2: "); pr2.display();
        System.out.println("pr1 == pr2: " + (pr1 == pr2));
        System.out.println("pr1.equals(pr2): " + pr1.equals(pr2));
        // Record is immutable - cannot modify fields
//         pr1.x = 10; // Compilation error!
        
        // Create new record instead of modifying existing one
        PointRecord pr3 = new PointRecord(10, pr1.y());
        System.out.println("\nAfter creating new PointRecord(10, pr1.y()):");
        System.out.print("pr1: "); pr1.display();
        System.out.print("pr3: "); pr3.display();
        System.out.println("pr1 == pr3: " + (pr1 == pr3));
        System.out.println("pr1.equals(pr3): " + pr1.equals(pr3));
        
        
        // Method demonstration
        System.out.println("\n--- METHOD DEMONSTRATION ---");
        
        PointRecord a = new PointRecord(1, 2);
        PointRecord b = new PointRecord(3, 4);
        
        System.out.print("Point a: "); a.display();
        System.out.print("Point b: "); b.display();
        System.out.println("Distance to point symmetric to a: " + a.distanceTosymmetricRelativeOY());
        System.out.print("Sum of a and b: "); PointRecord.add(a, b ).display();
        
        // Keyboard input testing
//        System.out.println("\n--- INPUT TESTING ---");
//        System.out.println("Creating point through record:");
//        PointRecord userPoint = PointRecord.readFromInput();
//        userPoint.display();
    }
}