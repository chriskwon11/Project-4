package spacecolonies;

import java.io.IOException;
import bsh.ParseException;
import queue.EmptyQueueException;
import student.TestCase;

/**
 * Test class for the ColonyReader
 * 
 * @author ckbbe
 *
 */
public class ColonyReaderTest extends TestCase {



    /**
     * Sets up each test case
     * 
     * @throws SpaceColonyDataException
     * @throws IOException
     * @throws ParseException
     */
    public void setUp(){
        //Left empty
    }

    /**
     * Testing the reader for a normal queue and planets file
     * @throws ParseException
     * @throws IOException
     * @throws SpaceColonyDataException
     */
    public void testReaderForPlanets1Input2() throws ParseException, IOException, SpaceColonyDataException {
        ColonyReader readerForPlanets1 = new ColonyReader("input2.txt",
            "planets1.txt");
        assertEquals(50, readerForPlanets1.getQueue().getSize());
        Planet[] planets = readerForPlanets1.getPlanets();
        assertEquals(3, planets.length);
    }
    
    /**
     * Testing the reader for a normal queue but incorrect planets file
     * @throws ParseException
     * @throws IOException
     * @throws SpaceColonyDataException
     */
    public void testReaderForPlanetsWrongNumber1InputAllAccept() throws ParseException, IOException, SpaceColonyDataException {
        Exception exception = null;
        try {
            ColonyReader readerForPlanets1 = new ColonyReader("inputAllAccept.txt",
                "planetsWrongNumber.txt");
            fail("ColonyReader() is not throwing an exception when" + "it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("ColonyReader() is throwing the wrong type of exceptions",
            exception instanceof ParseException);
       
        
    }
    
    
}
