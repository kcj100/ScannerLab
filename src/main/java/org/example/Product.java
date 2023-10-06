package org.example;

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

    public double getTotal() {
        return qty * price + calculateFeeByMiles();
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

    /**
     * return dividers as String according to each header's length
     */
    private String processDividers(String[] headers) {
        StringBuilder dividers = new StringBuilder();
        int counter = 0;
        for (String s : headers) {
            for (int i = 0; i < s.length(); i++) {
                dividers.append("-");
            }
            counter++;
            if (counter < headers.length) {
                dividers.append("\t");
            }
        }
        return dividers.toString();
    }

    private String processSpacesForValues(String[] dividers, String[] values) {
        StringBuilder valuesBuilder = new StringBuilder();

        // values length in array form will always be the same as dividers length in array form
        // keeping track of values array index with counter
        int counter = 0;

        for (String divider : dividers) {
            int spacesCount = 0;

            /*
              if current divider's length is less than current value's length,
             how many spaces that will be added will be according to the difference
             between value's current length and divider's current length
            */
            if (divider.length() < values[counter].length()) {
                spacesCount = values[counter].length() - divider.length();
            } else {
                // else how spaces that will be added will be determined by divider.length
                // divided by 2
                spacesCount = divider.length() / 2;
            }
            /*
             further processing to use the remainder of divider.length % spacesCount
             to serve as the new spacesCount value, to ensure number of spaces that
             are added account for the divider.length, as remainder will be different
             most of the time as divider.length decreases and increases in value
            */
            spacesCount = divider.length() % spacesCount;
            StringBuilder spaces = new StringBuilder();

            // add spaces to spaces according to spacesCount
            for (int i = 0; i < spacesCount; i++) {
                spaces.append(" ");
            }
            if (counter == 0) {
                valuesBuilder.append(spaces).append(values[counter]).append("\t");
            } else {
                valuesBuilder.append(spaces).append(values[counter]).append("\t");
            }

            // tab added after appending current value in array to valuesBuilder

            counter++;
        }
        return valuesBuilder.toString();
    }

//    private String processHeaders(String[] headers, String[] values) {
//        StringBuilder headersBuilder = new StringBuilder();
//        for (int i = 0; i < headers.length; i++) {
//            if (headers[i].length() < values[i].length()) {
//
//            }
//        }
//    }

    @Override
    public String toString() {
        StringBuilder headers = new StringBuilder();
        StringBuilder dividers = new StringBuilder();
        StringBuilder values = new StringBuilder();
        headers.append("Product\t")
                .append("Qty\t")
                .append("Price\t")
                .append("Miles\t")
                .append("Total");

        // generate new dividers from processDividers method
        dividers.append(processDividers(headers.toString().split("\t")));
        values.append(product + "\t" + qty + "\t" + price + "\t" + miles + "\t" + getTotal());

        /*
         create newValues with correct amount of spaces based on values and dividers
         length after splitting by tab
        */
        StringBuilder newValues = new StringBuilder(
                processSpacesForValues(dividers.toString().split("\t"),
                        values.toString().split("\t")));
        return headers.toString() + "\n" + dividers.toString() + "\n" + newValues.toString();
    }
}
