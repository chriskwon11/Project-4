package spacecolonies;

import student.TestCase;

/**
 * Test class for the Skills class
 * 
 * @author Chris Kwon
 *
 */
public class SkillsTest extends TestCase {
    private Skills base;
    private Skills greater;
    private Skills same;
    private Skills lower;


    /**
     * Sets up each test case
     */
    public void setUp() {
        base = new Skills(3, 4, 5);
        greater = new Skills(4, 5, 6);
        lower = new Skills(2, 3, 4);
        same = new Skills(3, 4, 5);
    }


    /**
     * Tests getAgriculture() for the base Skills object
     */
    public void testGetAgriculture() {
        assertEquals(3, base.getAgriculture());
    }


    /**
     * Tests getMedicine() for the base Skills object
     */
    public void testGetMedicine() {
        assertEquals(4, base.getMedicine());
    }


    /**
     * Tests getTechnology() for the base Skills object
     */
    public void testGetTechnology() {
        assertEquals(5, base.getTechnology());
    }


    /**
     * Tests isBelow() for when the object being compared to has greater skill
     */
    public void testIsBelowGreater() {
        assertEquals(true, base.isBelow(greater));
    }


    /**
     * Tests isBelow() for when the object being compared to has lower skill
     */
    public void testIsBelowLower() {
        assertEquals(false, base.isBelow(lower));
    }


    /**
     * Tests isBelow() for when the object being compared to has the same skill
     */
    public void testIsBelowSame() {
        assertEquals(true, base.isBelow(same));
    }


    /**
     * Tests the toString() method for the base Skills object
     */
    public void testToStringBase() {
        assertEquals("A:3 M:4 T:5", base.toString());
    }


    /**
     * Tests equals() for when the object is null
     */
    public void testsEqualsNull() {
        Skills nullSkill = null;
        assertEquals(false, base.equals(nullSkill));
    }


    /**
     * Tests equals() for when the object is of a different class
     */
    public void testEqualsDiffClass() {
        assertEquals(false, base.equals(0));
    }


    /**
     * Tests equals() for when the object is of the same class but
     * of different skill levels
     */
    public void testEqualsSameClassDiffSkill() {
        assertEquals(false, base.equals(greater));
    }

    /**
     * Tests equals() for when the object is of the same class and
     * same skill levels
     */
    public void testEqualsSameClassSameSkill() {
        assertEquals(true, base.equals(same));
    }
}
