package spacecolonies;

/**
 * Creates a person object which contains a string for a person's name,
 * a skills object, and a String representation of their planet preference.
 * 
 * @author Chris Kwon
 *
 */
public class Person {
    private String name;
    private Skills skills;
    private String planetPreference;


    /**
     * Creates a person object with information about their name, skill levels,
     * and planet preference
     * 
     * @param name
     *            Name of the person
     * @param agri
     *            Agriculture skill level
     * @param medi
     *            Medicine skill level
     * @param tech
     *            Technology skill level
     * @param planet
     *            Name of preferred planet
     */
    public Person(String name, int agri, int medi, int tech, String planet) {
        this.name = name;
        skills = new Skills(agri, medi, tech);
        planetPreference = planet;
    }


    /**
     * Getter method for the person's name
     * 
     * @return person's name
     */
    public String getName() {
        return name;
    }


    /**
     * Getter method for the person's skill
     * 
     * @return person's skills
     */
    public Skills getSkills() {
        return skills;
    }


    /**
     * Getter method for the planet name
     * 
     * @return preferred planet name
     */
    public String getPlanetName() {
        return planetPreference;
    }


    /**
     * Returns the person's name, skills, and preferred planet
     * if the person has one as a string
     * 
     * @return String representation of the person
     */
    public String toString() {
        StringBuilder person = new StringBuilder();
        if (this.planetPreference.length() <= 0) {
            person.append("No-Planet ");
        }
        person.append(name);
        person.append(" ");
        person.append(skills.toString());
        if (this.planetPreference.length() > 0) {
            person.append(" Wants: ");
            person.append(this.planetPreference);
        }
        return person.toString();
    }


    /**
     * Compares if two person objects are equal
     * 
     * @return true if the two person objects have the same name, skills,
     *         and planet preference values
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        else if (obj.getClass() != this.getClass()) {
            return false;
        }
        else {
            Person other = (Person)obj;
            return this.name == other.name && this.skills.equals(other.skills)
                && this.planetPreference == other.planetPreference;
        }
    }
}
