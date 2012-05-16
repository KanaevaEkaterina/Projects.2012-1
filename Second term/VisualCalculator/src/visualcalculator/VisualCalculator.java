package visualcalculator;

/**
 * create interface for calculator
 *
 * @author Kanaeva Ekaterina
 */
public class VisualCalculator {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new CalculatorApplication().setVisible(true);
            }
        });
        CalculatorApplication calc = new CalculatorApplication();
        calc.setDefaultCloseOperation(CalculatorApplication.EXIT_ON_CLOSE);
        
    }
}
