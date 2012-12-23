/*
 * create computer's network
 */
package network;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

/**
 *
 * @author Kanaeva Yekaterina
 */
public class NetWork {
    
   /**
    * constructor for Network
    * 
    * @param matrix adjacency matrix of the network
    * @param computers array of computers in the network
    */
    public NetWork(int[][] matrix, Computer[] computers) throws InvalidArgumentsException {
        if (matrix.length == computers.length){
            this.matrix = matrix;
            this.computers = computers;
        }
        else {
            throw new InvalidArgumentsException("Arguments in constructor are invalid");
        }
    }
    
    /**
    * Every 10 seconds changes state of the network and shows result
    * 
    */
    public void work(){
        Timer time = new Timer();
        TimerTask task = new TimerTask() {

            /**
             * Actions to do
             */
            @Override
            public void run() {
                changeState();
                showState();
            }
        };
        time.schedule(task, 10000, 10000);
    }
    
    /**
    * changes state of the network
    * 
    */
    private void changeState(){
        for (int i = 0; i < computers.length; i++){
            if (computers[i].getState()){ //infected
                for (int j = i+1; j < computers.length; j++){
                    if (matrix[i][j] == 1) {
                        computers[j].infection();
                    }
                }
            }
        }
    }
    
    /**
    * shows state of the network
    * 
    */
    private void showState(){
        for (int i = 0; i < computers.length; i++){
            System.out.println(i + "-" + computers[i].getState());
        }
         System.out.println();
    }
    
    /**
    * adjacency matrix of the network
    * 
    */
    private int[][] matrix;
    
   /**
    * array of computers in the network
    * 
    */
    private Computer[] computers;
    
    /**
    * test for the network
    * 
    */
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        for (int j = 0; j < matrix.length; j++){
            for (int k = j+1; k < matrix.length; k++){
                if (k == j) matrix[j][k] = 0;
            }
        }
        matrix[0][1] = matrix[1][0] = 1;
        matrix[0][2] = matrix[2][0] = 0;
        matrix[0][3] = matrix[3][0] = 1;
        matrix[1][2] = matrix[2][1] = 1;
        matrix[1][3] = matrix[3][1] = 1;
        matrix[2][3] = matrix[3][2] = 0;
        
        OS windows = new Windows();
        OS linux = new Linux();
        OS netWare = new NetWare();
        Computer[] comps = new Computer[4];
        comps[0] = new Computer(windows, true);
        comps[1] = new Computer(windows, true);
        comps[2] = new Computer(linux, false);
        comps[3] = new Computer(netWare, false);
        try {
            NetWork net = new NetWork(matrix, comps);
            net.showState();
            net.work();
        } catch (InvalidArgumentsException e) {
            e.printStackTrace();
        }
    }
}
