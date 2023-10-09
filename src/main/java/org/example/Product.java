package org.example;

import java.nio.charset.StandardCharsets;
import java.util.Formatter;

public class Product {
    private String product;
    private int qty;
    private double price;
    private double miles;

    public Product(String product, int qty, double price, double miles) {
        this.product = product;
        this.qty = qty;
        this.price = price;
        this.miles = miles;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMiles() {
        return miles;
    }

    public void setMiles(double miles) {
        this.miles = miles;
    }

    public String getTotal() {
        double total = qty * price + calculateFeeByMiles();
        return "$" + String.format("%.2f", total);
    }

    private double calculateFeeByMiles() {
        if (miles > 0 && miles <= 5) {
            return 2.0;
        } else if (miles > 5 && miles <= 15) {
            return 5.0;
        } else if (miles > 15 && miles <= 25) {
            return 10.0;
        } else if (miles > 25 && miles <= 50) {
            return 15.0;
        } else if (miles > 50) {
            return 20.0;
        } else {
            return 0.0;
        }
    }

    @Override
    public String toString() {
        // Define the headers and values
        String[] headers = {"Product", "Qty", "Price", "Miles", "Total"};
        String formattedPrice = "$" + String.format("%.2f", price);
        String[] values = {product, String.valueOf(qty), formattedPrice, String.valueOf(miles), getTotal()};

        // Calculate the maximum width for each column
        int[] columnWidths = new int[headers.length];
        for (int i = 0; i < headers.length; i++) {
            columnWidths[i] = Math.max(headers[i].length(), values[i].length());
        }

        // Create a StringBuilder to build the formatted output
        StringBuilder output = new StringBuilder();

        // Append headers with dividers
        for (int i = 0; i < headers.length; i++) {
            Formatter headerFormatter = new Formatter();
            headerFormatter.format("%-" + columnWidths[i] + "s", headers[i]);
            output.append(headerFormatter).append("\t");
            headerFormatter.close();
        }
        output.append("\n");

        // Append a row of dashes to separate headers and values
        for (int i = 0; i < headers.length; i++) {
            output.append("-".repeat(columnWidths[i])).append("\t");
        }
        output.append("\n");

        // Append values
        for (int i = 0; i < values.length; i++) {
            Formatter valueFormatter = new Formatter();
            valueFormatter.format("%-" + columnWidths[i] + "s", values[i]);
            output.append(valueFormatter).append("\t");
            valueFormatter.close();
        }

        return output.toString();
    }

}
