package spacecolonies;

import student.TestCase;

/**
 * Test class for the Person class
 * 
 * @author Chris Kwon
 *
 */
public class PersonTest extends TestCase {
    private Person person;
    private Person diffPerson;
    private Person samePerson;


    public void setUp() {
        person = new Person("Chris Kwon", 3, 4, 5, "Planet 1");
        diffPerson = new Person("Kayo Kim", 3, 4, 5, "");
        samePerson = new Person("Chris Kwon", 3, 4, 5, "Planet 1");
    }


    /**
     * Tests the getName() method for person
     */
    public void testGetNamePerson() {
        assertEquals("Chris Kwon", person.getName());
    }


    /**
     * Tests the getSkills() method for person
     */
    public void testGetSkillsPerson() {
        Skills personSkills = person.getSkills();
        assertEquals(3, personSkills.getAgriculture());
        assertEquals(4, personSkills.getMedicine());
        assertEquals(5, personSkills.getTechnology());
    }


    /**
     * Tests the getPlanetName() method for person
     */
    public void testGetPlanetPerson() {
        assertEquals("Planet 1", person.getPlanetName());
    }


    /**
     * Tests the toString() method for person who has a preferred planet
     */
    public void testToStringPersonPlanet() {
        assertEquals("Chris Kwon A:3 M:4 T:5 Wants: Planet 1", person
            .toString());
    }


    /**
     * Tests the toString() method for person who doesn't have a preferred
     * planet
     */
    public void testToStringPersonNoPlanet() {
        assertEquals("No-Planet Kayo Kim A:3 M:4 T:5", diffPerson.toString());
    }


    /**
     * Tests equals() for when the object is null
     */
    public void testsEqualsNull() {
        Skills nullSkill = null;
        assertEquals(false, person.equals(nullSkill));
    }


    /**
     * Tests equals() for when the object is of a different class
     */
    public void testEqualsDiffClass() {
        assertEquals(false, person.equals(0));
    }


    /**
     * Tests equals() for when the object is of the same class but
     * a different person
     */
    public void testEqualsSameClassDiffPerson() {
        assertEquals(false, person.equals(diffPerson));
    }


    /**
     * Tests equals() for when the object is of the same class and
     * the same person
     */
    public void testEqualsSameClassSamePerson() {
        assertEquals(true, person.equals(samePerson));
    }
}
