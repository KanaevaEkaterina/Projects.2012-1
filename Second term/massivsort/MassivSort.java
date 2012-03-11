package massivsort;
import java.io.*;

public class MassivSort {
   private static void bubbleSort(int [] mass) {
        for (int i = 1; i <= mass.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j <= mass.length - 2 ; j++) {
                if (mass[j] > mass[j + 1]) {
                    int change = mass[j];
                    mass[j] = mass[j + 1];
                    mass[j + 1] = change;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }

	}
    }
    
    public static void main(String[] args) { 
        BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
        System.out.print("Length of massiv: ");
        int [] mass = null;
        try {
            int len = Integer.parseInt(in.readLine());
            mass = new int[len];
            for (int i = 0; i < len; i++) {
                mass[i] = len - i;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print("UnSorted: ");
        for (int i = 0; i < mass.length; i++) {
            System.out.print(mass[i]);
            System.out.print(" ");
        }
        System.out.println(" ");
        System.out.print("Sorted: ");
        bubbleSort(mass);
        for (int i = 0; i < mass.length; i++) {
            System.out.print(mass[i]);
            System.out.print(" ");
        }
        System.out.println(" ");
    }
}
