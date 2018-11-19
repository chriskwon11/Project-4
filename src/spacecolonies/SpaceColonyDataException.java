package spacecolonies;

/**
 * This will be thrown if data is incorrect in the input files
 * @author Chris Kwon
 * 
 */
public class SpaceColonyDataException extends Exception{

    /**
     * Passes the string parameter to the constructor of the standard
     * Java exception class
     * @param string String indicating the error
     */
    public SpaceColonyDataException(String string) {
        super(string);
    }
}
