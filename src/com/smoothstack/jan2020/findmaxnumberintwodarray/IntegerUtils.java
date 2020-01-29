package com.smoothstack.jan2020.findmaxnumberintwodarray;

import java.util.*;

public class IntegerUtils {


    /**
     * Generate 2D int Array with ramdom value
     *
     *
     *
     * @param x dimension of array, x > 0
     * @param y dimension of array, y > 0
     * @param bound boundary of random
     * @return int[x][y] with random int value
     */
    public static int[][] generateTwoDimensionArrayOfRandomInt(final int x, final int y, final int bound) {

        if (x < 1 || y < 1) throw new IllegalArgumentException("Array dimension is invalid. (x and y must greater than 0)");

        int[][] intArray = new int[x][y];
        final Random random = new Random();

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                intArray[i][j] = random.nextInt(bound);
            }
        }

        return intArray;
    }

    /**
     * Index and Sort 2D int Array
     *
     * intArray[i][j] = value -> array[N][0] = value, array[N][1] = i, array[N][2] = j;
     *
     * @param intArray
     * @return sorted and Index int[][]
     */

    public static int[][] indexAndSortIntArray(int[][] intArray) {

        int[][] indexedAndSorted = new int[intArray.length * intArray[0].length][3];

        for (int i = 0; i < intArray.length; i++) {
            for (int j = 0; j < intArray[i].length; j++) {

                // According to intArray[x][y] = value

                // Store value at indexedAndSorted[N][0]
                indexedAndSorted[i*intArray[i].length + j][0] = intArray[i][j];

                // Store dimension x at indexedAndSorted[N][1]
                indexedAndSorted[i*intArray[i].length + j][1] = i;

                // Store dimension y at indexedAndSorted[N][1]
                indexedAndSorted[i*intArray[i].length + j][2] = j;
            }
        }

        /*
         * In order to sort the indexed array, we have to compare the value at indexedAndSorted[N][0]
         */
        Arrays.sort(indexedAndSorted,
                // Comparator<int> function generator
                Comparator.comparingInt(
                        // extract sort key from int value at location inArrayLocation[i*j][0]
                        // eachElement = inArrayLocation[i*j]
                        eachElement -> eachElement[0]
                )
        );

        return indexedAndSorted;
    }
}
