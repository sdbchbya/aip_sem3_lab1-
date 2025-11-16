package com.mycompany.project1_7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Project1_7 {
    
    // Part 1: Methods for input and array processing
    private static List<Integer> readArrayFromConsole() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> array = new ArrayList<>();

        System.out.println("Enter array A elements separated by space (N must be even):");
        String inputLine = scanner.nextLine();
        String[] elements = inputLine.split(" ");

        if (elements.length % 2 != 0) {
            System.out.println("Error: Number of elements must be even.");
            return readArrayFromConsole(); // Recursive call for re-entry
        }

        for (String element : elements) {
            try {
                array.add(Integer.parseInt(element));
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter integers only.");
                return readArrayFromConsole(); // Recursive call for re-entry
            }
        }

        return array;
    }

    private static List<Integer> createArrayB(List<Integer> arrayA) {
        List<Integer> arrayB = new ArrayList<>();
        int powerOfTwo = 1;

        while (powerOfTwo <= arrayA.size()) {
            arrayB.add(arrayA.get(powerOfTwo - 1)); //assume index of element is its number - 1
            powerOfTwo *= 2;
        }

        return arrayB;
    }
    
    // Helper method for array output
    private static void printArray(String name, List<Integer> array) {
        System.out.print(name + ": [");
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i));
            if (i < array.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    // Main method
    public static void main(String[] args) {
        System.out.println("Program to create array B from array A elements with indices 1, 2, 4, 8, 16...");
        
        // Read array A
        List<Integer> arrayA = readArrayFromConsole();
        
        // Create array B
        List<Integer> arrayB = createArrayB(arrayA);
        
        // Display results
        System.out.println("\nResults:");
        printArray("Array A", arrayA);
        printArray("Array B", arrayB);
    }
}

