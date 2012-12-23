/*
 * class for computers in network
 * 
 */
package network;

import java.util.Random;

/**
 *
 * @author Kanaeva Yekaterina
 */
public class Computer {

    /**
     * constructor for computer
     * 
     * @param newOS OS of the new computer 
     * @param infection true, if the computer should be infected, false - otherwise
     */
    public Computer(OS newOS, boolean infection) {
        this.os = newOS;
        this.isInfected = infection;
    }

    /**
     * infect the computer on not, according to it's OS
     * 
     */
    public void infection() {
        Random rand = new Random();
        if (rand.nextInt(100) <= os.chanceOfInfection()) {
            this.isInfected = true;
        }
    }

    /**
     * return stage of the computer
     * 
     * @return true, if the computer should be infected, false - otherwise 
     */
    public boolean getState() {
        return this.isInfected;
    }
    /**
     * OS of the computer
     * 
     */
    private OS os;
    /**
     * stage of the computer: true, if the computer should be infected, false - otherwise 
     * 
     */
    private boolean isInfected;
}
