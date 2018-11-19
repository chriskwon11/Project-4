package spacecolonies;

/**
 * Creates a Skills object which contains three integers
 * representing the skill level from 1-5 for agriculture
 * medicine and technology.
 * 
 * @author Chris Kwon
 *
 */
public class Skills {
    private int agriculture;
    private int medicine;
    private int technology;


    /**
     * Skills constructor which sets the three values for
     * agriculture, medicine, and technology skill level.
     * 
     * @param ag
     * @param med
     * @param tech
     */
    public Skills(int ag, int med, int tech) {
        agriculture = ag;
        medicine = med;
        technology = tech;
    }


    /**
     * Getter method for the Agriculture skill level
     * 
     * @return the integer value for agriculture
     */
    public int getAgriculture() {
        return agriculture;
    }


    /**
     * Getter method for the Medicine skill level
     * 
     * @return the integer value for medicine
     */
    public int getMedicine() {
        return medicine;
    }


    /**
     * Getter method for the Technology skill level
     * 
     * @return the integer value for technology
     */
    public int getTechnology() {
        return technology;
    }


    /**
     * Compares a given "other" Skills is lower than "this" Skills
     * 
     * @param other
     * @return true if agriculture, medicine, and technology of "this"
     *         is lower than or equal to the values of the other
     */
    public boolean isBelow(Skills other) {
        return this.agriculture <= other.agriculture
            && this.medicine <= other.medicine
            && this.technology <= other.technology;
    }

    /**
     * Returns the skill levels for agriculture, medicine, 
     * and technology as a string
     * @return String representation of Skills
     */
    public String toString() {
        StringBuilder skills = new StringBuilder();
        skills.append("A:");
        skills.append(this.agriculture);
        skills.append(" M:");
        skills.append(this.medicine);
        skills.append(" T:");
        skills.append(this.technology);
        return skills.toString();
    }
    /**
     * Checks if the given Skills object is equal to "this" Skills object
     * 
     * @param object
     *            to be compared to
     * @return true if the two objects have equal agriculture, medicine,
     *         and technology skill levels
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        else if (obj.getClass() != this.getClass()) {
            return false;
        }
        else {
            Skills other = (Skills)obj;
            return this.agriculture == other.agriculture
                && this.medicine == other.medicine
                && this.technology == other.technology;
        }
    }
}
