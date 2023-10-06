package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to our supermarket's delivery service!");
        System.out.println("Choose your product: ");
        System.out.println("1. Rice - $5.00\n2. Bread - $4.50\n3. Water Bottle - $1.00");
        int productNumber = scanner.nextInt();
        String productName = "";
        scanner.nextLine();
        double price = 0.0;
        switch (productNumber) {
            case 1:
                productName = "Rice";
                price = 5.0;
                break;
            case 2:
                productName = "Bread";
                price = 4.5;
                break;
            case 3:
                productName = "Water Bottle";
                price = 1.0;
        }

        System.out.println("Enter quantity for " + productName);
        int qty = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter how far you are from our location: ");
        double miles = scanner.nextDouble();
        Product product = new Product(productName, qty, price, miles);
        System.out.println(product);
    }
}