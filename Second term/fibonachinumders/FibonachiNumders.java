package fibonachinumders;
import java.io.*;

public class FibonachiNumders {
    private static int fibonachi(int n) {
        if (n <= 2)
            return 1;
        else
            return fibonachi(n - 1) + fibonachi(n - 2);
    }
    
    public static void main(String[] args) {
         BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
         System.out.print("Enter number: ");
         try {
            int num = Integer.parseInt(in.readLine());
            System.out.print("Fibonacci numbers: ");
            for (int i = 1; i <= num; i++) {
                System.out.print(fibonachi(i));
                System.out.print(" "); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" "); 
    }
}
