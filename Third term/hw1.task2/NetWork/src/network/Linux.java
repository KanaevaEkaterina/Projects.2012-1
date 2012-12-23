/*
 * class for Linux OS
 * 
 */
package network;

/**
 *
 * @author Kanaeva Yekaterina
 */
public class Linux implements OS {
    
    /**
     * return chance of infection for Linux
     *
     * @return int chance of infection
     */
    @Override
    public int chanceOfInfection(){
        return this.chanceOfInfection;
    }
    
    /**
     * value of chance of infection for Linux
     *
     */
    private int chanceOfInfection = 30;
}
