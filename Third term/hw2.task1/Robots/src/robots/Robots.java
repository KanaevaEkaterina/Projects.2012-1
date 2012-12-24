/*
 * check, if this configuration of robots can be distroyed
 * 
 */
package robots;

/**
 *
 * @author Kanaeva Ekaterina
 */
public class Robots {

    /**
     * constructor for graph with robots
     *
     * @param matrix adjacency matrix
     * @param robots array with 1 on places, where are robots
     */
    public Robots(int[][] matrix, int[] robots) throws InvalidArgumentsException {
        if (matrix.length == robots.length) {
            this.matrix = matrix;
            this.robots = robots;
            this.color = new int[this.robots.length];
            for (int i = 0; i < color.length; i++) {
                color[i] = 0;
            }
        } else {
            throw new InvalidArgumentsException("Arguments in constructor are invalid");
        }
    }
    
    /**
     * show incoming data
     *
     */
    public void show() {
        System.out.println("Adjacency matrix:");
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("Robots are on positions:");
        for (int k = 0; k < this.robots.length; k++) {
            if (robots[k] == 1) {
                System.out.print(k);
            }
        }
        System.out.println();
    }

    /**
     * check, if this configuration of robots can be distroyed
     *
     * @return true, if such configuration exist, false - otherwise
     */
    public boolean action() {
        this.matrix = this.morph();
        int col = 1;
        for (int i = 0; i < this.robots.length; i++) {
            if (this.robots[i] == 1 && this.color[i] == 0) {
                if (dfs(i, col) < 2) {
                    return false;
                }
                col++;
            }
        }
        return true;
    }

    /**
     * delete verteces in which can't be robots, create new edges to the verteces where can be robots
     *
     * @return int[][] araay - new adjacency matrix
     */
    private int[][] morph() {
        int[][] newMatrix = new int[this.matrix.length][this.matrix.length];
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix.length; j++) {
                if (this.matrix[i][j] == 1) {
                    for (int k = 0; k < this.matrix.length; k++) {
                        if (this.matrix[j][k] == 1) {
                            newMatrix[i][k] = 1;
                        }
                    }
                }
            }
        }
        return newMatrix;
    }

    /**
     * count numder of robots in one connected component
     *
     * @param num number of vertex from which the search begins
     * @param col color of current connected component
     * @return int numder of robots in one connected component
     */
    private int dfs(int num, int col) {
        int count = 0;
        if (this.robots[num] == 1) {
            count++;
        }
        this.color[num] = col;
        for (int i = 0; i < this.matrix.length; i++) {
            if (this.matrix[num][i] == 1) {
                if (this.color[i] == 0) {
                    count += dfs(i, col);
                }
            }
        }
        return count;
    }

    /**
     * adjacency matrix
     *
     */
    private int[][] matrix;
    /**
     * array with 1 on positions where are robots in graph
     *
     */
    private int[] robots;
    /**
     * array, where index - number of vertex, value - "color", in which connected component is vertex
     *
     */
    private int[] color;

    public static void main(String[] args) {

        int[][] matrix = new int[5][5];
        matrix[0][1] = 1;
        matrix[0][2] = 0;
        matrix[0][3] = 1;
        matrix[0][4] = 0;
        matrix[1][2] = 0;
        matrix[1][3] = 1;
        matrix[1][4] = 0;
        matrix[2][3] = 0;
        matrix[2][4] = 1;
        matrix[3][4] = 1;
        for (int j = 0; j < matrix.length; j++) {
            for (int k = 0; k < matrix.length; k++) {
                if (k == j) {
                    matrix[j][k] = 0;
                }
                if (j > k) {
                    matrix[j][k] = matrix[k][j];
                }
            }
        }
        int[] robotsPos = {0, 1, 1, 1, 0};
        try {
            Robots robots = new Robots(matrix, robotsPos);
            robots.show();
            System.out.println(robots.action());
        } catch (InvalidArgumentsException e) {
            e.printStackTrace();
        }
    }
}
