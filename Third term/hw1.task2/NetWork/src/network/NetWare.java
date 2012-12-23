/*
 * class for Netware OS
 * 
 */
package network;

/**
 *
 * @author Kanaeva Yekaterina
 */
public class NetWare implements OS {
    
    /**
     * return chance of infection for NetWare
     *
     * @return int chance of infection
     */
    @Override
    public int chanceOfInfection(){
        return this.chanceOfInfection;
    }
    
    /**
     * value of chance of infection for NetWare
     *
     */
    private int chanceOfInfection = 20;
}
