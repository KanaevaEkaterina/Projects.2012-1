package sortofcolumns;

import java.io.*;
import java.util.Random;

public class SortOfColumns {

    private static int[][] changeColumn(int[][] mass, int j) {
        int[] curr = new int[mass.length];
        for (int k = 0; k < mass.length; k++) {
            curr[k] = mass[k][j];
            mass[k][j] = mass[k][j + 1];
            mass[k][j + 1] = curr[k];
        }
        return mass;
    }

    private static int[][] columnSort(int[][] mass, int column) {
        for (int j = 1; j <= column - 1; j++) {
            boolean flag = true;
            for (int k = 0; k <= column - 2; k++) {
                if (mass[0][k] > mass[0][k + 1]) {
                    changeColumn(mass, k);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }

        }
        return mass;
    }

    private static void printMatrix(int[][] mass, int column) {
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(mass[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter number of lines in array: ");
        int[][] mass = null;
        int line = 0;
        int column = 0;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            line = Integer.parseInt(in.readLine());
            System.out.print("Enter number of columns in array: ");
            column = Integer.parseInt(in.readLine());
            mass = new int[line][column];
        } catch (Exception e) {
            e.printStackTrace();
        }
        Random rand = new Random();
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                mass[i][j] = rand.nextInt(9) + 1;
            }
        }
        System.out.println("Current array:");
        printMatrix(mass, column);
        System.out.println("Sorted array:");
        printMatrix(columnSort(mass, column), column);
    }
}
