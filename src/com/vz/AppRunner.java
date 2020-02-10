package com.vz;

import java.util.Arrays;

public class AppRunner {

    public static void main(String[] args) {
	    int primaryArrCapacity = 5;
	    int secondaryArrCapacity = 3;
	    int fromNumber = 3;
	    int toNumber = 5;
	    int cells = getRandomInt(fromNumber, toNumber);
	    int value = 1;
	    int[][] baseArray = new int[primaryArrCapacity][secondaryArrCapacity];

        System.out.println("=== before ===");
	    showArrays(baseArray);
        System.out.printf("Items to fill -> %02d\n\n", cells);

        System.out.println("=== after ===");
        showArrays(fillUpArrays(baseArray, cells, value));

    }
    static void showArrays(int[][] array){
        if (array == null) {
            System.out.println("Incorrect input data!");
        } else {
            for (int[] arr : array) {
                System.out.println(Arrays.toString(arr));
            }
        }
    }
    static int getRandomInt(int fromNumber, int toNumber){
            return (int)(Math.random()*(toNumber - fromNumber + 1) + fromNumber);
    }

    static int[][] fillUpArrays(int[][] array, int cells, int value){
        if(array == null) {
            System.out.println("Incorrect input data!");
            return null;
        }
        int[][] freeCellsCoordinates;
        int[] coordinate;
        for (int i = 0; i < cells; i++) {
            freeCellsCoordinates = getFreeCellsCoordinates(array);
            if(freeCellsCoordinates.length == 0) break;
            coordinate = freeCellsCoordinates[(int) (Math.random()*freeCellsCoordinates.length)];
            array[coordinate[0]][coordinate[1]] = value;
        }

        return array;
    }
    static int[][] getFreeCellsCoordinates(int[][] array){
        int result[][] = new int[countZerosInArray(array)][2];
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j] == 0) {
                    result[k][0] = i;
                    result[k][1] = j;
                    k++;
                }
            }

        }
        return result;
    }

    static int countZerosInArray(int[][] array){
        int count = 0;
        for (int[] arr: array) {
          count += arr.length - Arrays.stream(arr).sum();
        }
        return count;
    }

}
