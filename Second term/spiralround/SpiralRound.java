package spiralround;
import java.io.*;
import java.util.Random;

public class SpiralRound {
    private static int[] spiral(int [][] mass) {
        int[] result = new int[mass.length * mass.length];
        int i = mass.length / 2;
        int j = mass.length / 2;
        int l = 1; // размер шага
        int sign = 1; // смена направления
        int n = 0; // номер одномерного массива
        int k; 
        while(l <= mass.length - 1) {
            for(k = 0; k < l; k++) {
                result[n] = mass[i][j];
                n++;
                i+=sign;  // либо вверх, либо вниз
             }
             for(k = 0; k < l; k++) {
                result[n] = mass[i][j];
                n++;
                j-=sign; // либо вправо, либо влево
             }
                l++; 
                sign = -sign; 
        }
        for(k = 0; k < l; k++) { // дойти до конца массива по последнему столбцу сверху вниз
            result[n] = mass[i][j];
            n++;
            i+=sign; 
        }
        return result;
    }

    private static void printMatrix(int [][] mass) {
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass.length; j++) {
                System.out.print(mass[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
   
    private static void printArray(int [] mass) {
        for (int i = 0; i < mass.length; i++) {
            System.out.print(mass[i] + " ");
        }
        System.out.println(" ");
        }
    
     public static void main(String[] args) {
        System.out.print("Enter number of elements in array: ");
        int[][] mass = null;
        BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
        try {
            int num = Integer.parseInt(in.readLine());
            mass = new int[num][num];
        } catch (Exception e) {
            e.printStackTrace();
        }
        Random rand = new Random();
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass.length; j++) {
                mass[i][j] = rand.nextInt(9) + 1;
            }
        }
        System.out.println("Current array:");
        printMatrix(mass);
        System.out.println("Spiral of array: (go down, clockwise)");
        printArray(spiral(mass));
    }
}
