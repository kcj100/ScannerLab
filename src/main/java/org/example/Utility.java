package org.example;

public class Utility {

    public static int spacesCalculator(String[] first, String[] second) {
        int counter = 0;
        int spacesCount = 0;
        for (String s : first) {


            /*
              if current first's length is less than current value's length,
             how many spaces that will be added will be according to the difference
             between value's current length and first's current length
            */
            if (s.length() < second[counter].length()) {
                spacesCount = second[counter].length() - s.length();
            } else {
                // else how spaces that will be added will be determined by first.length
                // divided by 2
                spacesCount = s.length() / 2;
            }
            /*
             further processing to use the remainder of first.length % spacesCount
             to serve as the new spacesCount value, to ensure number of spaces that
             are added account for the first.length, as remainder will be different
             most of the time as first.length decreases and increases in value
            */
            spacesCount = s.length() % spacesCount;
        }
        return spacesCount;
    }
}
