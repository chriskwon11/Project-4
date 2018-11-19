package spacecolonies;

import student.TestCase;

/**
 * Test class for the Planet class
 * 
 * @author Chris Kwon
 *
 */
public class PlanetTest extends TestCase {
    private Planet planet;


    /**
     * Sets up each test case
     */
    public void setUp() {
        planet = new Planet("Mars", 3, 4, 5, 10);
    }


    /**
     * Tests the set and get name methods
     */
    public void testSetAndGetNameMethods() {
        assertEquals("Mars", planet.getName());
        planet.setName("Jupiter");
        assertEquals("Jupiter", planet.getName());
    }


    /**
     * Tests the getSkills method for the planet
     */
    public void testGetSkillsPlanet() {
        assertEquals(3, planet.getSkills().getAgriculture());
        assertEquals(4, planet.getSkills().getMedicine());
        assertEquals(5, planet.getSkills().getTechnology());
    }


    /**
     * Tests the getPopulationSize method for the planet
     */
    public void testGetPopulationSizePlanet() {
        assertEquals(0, planet.getPopulationSize());
    }


    /**
     * Tests the getCapacity method for the planet
     */
    public void testGetCapacityPlanet() {
        assertEquals(10, planet.getCapacity());
    }


    /**
     * Tests the getAvailability method for the planet
     */
    public void testGetAvailabilityPlanet() {
        assertEquals(10, planet.getAvailability());
    }


    /**
     * Tests the isFull method for when the planet is full
     */
    public void testIsFullFullPlanet() {
        assertEquals(0, planet.getPopulationSize());
        for (int i = 0; i < planet.getCapacity(); i++) {
            Person person = new Person("Chris", 6, 6, 6, "planet");
            planet.addPerson(person);
        }
        assertEquals(10, planet.getPopulationSize());
        assertEquals(true, planet.isFull());
    }


    /**
     * Tests the isFull method for when the planet isn't full
     */
    public void testIsFullNotFullPlanet() {
        assertEquals(false, planet.isFull());
    }


    /**
     * Tests addPerson when the planet is full
     */
    public void testAddPersonFullPlanet() {
        for (int i = 0; i < planet.getCapacity() - 1; i++) {
            Person person = new Person("Chris", 6, 6, 6, "planet");
            planet.addPerson(person);
        }
        assertEquals(9, planet.getPopulationSize());
        assertEquals(true, planet.addPerson(new Person("Jack", 6, 6, 6,
            "planet")));
        assertEquals(10, planet.getPopulationSize());
        assertEquals(false, planet.addPerson(new Person("Jack", 6, 6, 6,
            "planet")));
        assertEquals(10, planet.getPopulationSize());
    }


    /**
     * Tests addPerson when the person is not qualified
     */
    public void testAddPersonNotQualified() {
        Person person = new Person("Adrian", 3, 4, 2, "planet");
        assertEquals(0, planet.getPopulationSize());
        assertEquals(false, planet.addPerson(person));
        assertEquals(0, planet.getPopulationSize());
    }


    /**
     * Tests toString for a planet with the name Mars,
     * a capacity of 10, A = 3, M = 4, T = 5, and population
     * of 4
     */
    public void testToStringForPlanet() {
        planet.addPerson(new Person("Chris", 6, 6, 6, "planet"));
        planet.addPerson(new Person("Chris", 6, 6, 6, "planet"));
        planet.addPerson(new Person("Chris", 6, 6, 6, "planet"));
        planet.addPerson(new Person("Chris", 6, 6, 6, "planet"));
        assertEquals(
            "Mars, population 4 (cap: 10), Requires: A >= 3, M >= 4, T >= 5",
            planet.toString());
    }
    
    /**
     * Tests the equals method when the object is null
     */
    public void testEqualsNullObject() {
        assertEquals(false, planet.equals(null));
    }
    
    /**
     * Tests the equals method for when the ohject is of a different class
     */
    public void testEqualsDifferentObject() {
        assertEquals(false, planet.equals(9));
    }
    
    /**
     * Tests the equals method for when the object is of the same class but is a different planet
     */
    public void testsEqualsSameObjectDifferentPlanet() {
        Planet earth = new Planet("Earth", 2, 3, 4, 9);
        assertEquals(false, planet.equals(earth));
    }
    
    /**
     * Tests the equals method for when the object is of the same class and same planet
     */
    public void testEqualsSameObjectSamePlanet() {
        Planet planet2 = new Planet("Mars", 3, 4, 5, 10);
        assertEquals(true, planet.equals(planet2));
    }
    
    /**
     * Tests compareTo method for all cases
     */
    public void testCompareToAllCases() {
        planet.addPerson(new Person("Chris", 6, 6, 6, "planet"));
        Planet planet2 = new Planet("Mars", 3, 4, 5, 10);
        Planet samePlanet = new Planet("Venus", 2, 2, 2, 10);
        assertEquals(0, planet2.compareTo(samePlanet));
        assertEquals(-1, planet.compareTo(planet2));
        assertEquals(1, planet2.compareTo(planet));
    }
}
