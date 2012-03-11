package factorial1;
import java.io.*;

public class Factorial1 {
    private static int factorialFunction(int n) {
        if (n == 1)
            return 1;
        return n * factorialFunction(n - 1);
    }
    public static void main(String[] args) {
         BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
        System.out.print("Enter number: ");
        try {
            int result = factorialFunction(Integer.parseInt(in.readLine()));
            System.out.print("Factorial: ");
            System.out.format("%d", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
       System.out.println(" ");
    }
}
