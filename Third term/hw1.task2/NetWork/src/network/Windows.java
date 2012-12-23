/*
 * class for Windows OS
 * 
 */
package network;

/**
 *
 * @author Kanaeva Yekaterina
 */
public class Windows implements OS {

    /**
     * return chance of infection for Windows
     *
     * @return int chance of infection
     */
    @Override
    public int chanceOfInfection() {
        return this.chanceOfInfection;
    }

    /**
     * value of chance of infection for Windows
     *
     */
    private int chanceOfInfection = 50;
}
