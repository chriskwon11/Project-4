package spacecolonies;

/**
 * Planet objects contains a string for the planet name, three
 * ints for their minimum skill requirements, an array of Person
 * objects for the current population, an into to store current
 * population size, and a final int for the maximum capacity.
 * 
 * @author Chris Kwon
 *
 */
public class Planet implements Comparable<Planet> {
    private String name;
    private Skills minSkills;
    private Person[] population;
    private int populationSize;
    private final int capacity;


    /**
     * Creates a planet object which has a name and a minimum
     * skills requirement as well as a population capacity
     * 
     * @param planetName
     *            Name of the planet
     * @param planetAgri
     *            Minimum agricultural skill
     * @param planetMedi
     *            Minimum medicinal skill
     * @param planetTech
     *            Minimum technological skill
     * @param planetCap
     *            Max population capacity
     */
    public Planet(
        String planetName,
        int planetAgri,
        int planetMedi,
        int planetTech,
        int planetCap) {
        name = planetName;
        minSkills = new Skills(planetAgri, planetMedi, planetTech);
        capacity = planetCap;
        populationSize = 0;
        population = new Person[capacity];
    }


    /**
     * Sets the name of the planet to the given string
     * 
     * @param planetName
     *            New name of the planet
     */
    public void setName(String planetName) {
        name = planetName;
    }


    /**
     * Returns the name of the planet
     * 
     * @return Name of the planet
     */
    public String getName() {
        return name;
    }


    /**
     * Returns the minimum skills of the planet
     * 
     * @return Skills field of the planet
     */
    public Skills getSkills() {
        return minSkills;
    }


    /**
     * Returns the array for the population of people on the planet
     * 
     * @return Population on the planet
     */
    public Person[] getPopulation() {
        return population;
    }


    /**
     * Returns the population size of the planet
     * 
     * @return Population size
     */
    public int getPopulationSize() {
        return populationSize;
    }


    /**
     * Returns the capacity of the planet
     * 
     * @return Planet capacity
     */
    public int getCapacity() {
        return capacity;
    }


    /**
     * Returns the availability of spaces on the planet
     * 
     * @return Planet availability
     */
    public int getAvailability() {
        return capacity - populationSize;
    }


    /**
     * Determines whether the planet is full or not
     * 
     * @return True if the population has reached max capacity,
     *         false otherwise
     */
    public boolean isFull() {
        return capacity == populationSize;
    }


    /**
     * Adds the given person if there is availability and
     * if they are qualified to live on this planet
     * 
     * @param newbie
     * @return True if the person was added, and false otherwise
     */
    public boolean addPerson(Person newbie) {
        if (!isFull() && this.isQualified(newbie)) {
            population[populationSize] = newbie;
            populationSize++;
            return true;
        }
        else {
            return false;
        }
    }


    /**
     * Checks to see if the given person is qualified to live
     * on the planet or not
     * 
     * @param person
     *            Person to be checked
     * @return True if the person is qualified and false otherwise
     */
    public boolean isQualified(Person person) {
        if (minSkills.isBelow(person.getSkills())) {
            return true;
        }
        else {
            return false;
        }
    }


    /**
     * Creates a string representation of the planet
     * 
     * @return String containing the planet's name,
     *         population size, capacity, and minimum skills
     */
    public String toString() {
        StringBuilder planet = new StringBuilder();
        planet.append(name + ", population ");
        planet.append(populationSize + " (cap: ");
        planet.append(capacity + "), Requires: A >= ");
        planet.append(minSkills.getAgriculture() + ", M >= ");
        planet.append(minSkills.getMedicine() + ", T >= ");
        planet.append(minSkills.getTechnology());
        return planet.toString();
    }


    /**
     * Determines whether or not two planets are equal
     * 
     * @return True if all 5 of a planet's input fields are equal
     *         and their populationSize is equal
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        else if (obj.getClass() != this.getClass()) {
            return false;
        }
        else {
            Planet other = (Planet)obj;
            return this.name == other.name && this.minSkills.equals(
                other.minSkills) && this.capacity == other.capacity
                && this.populationSize == other.populationSize;
        }
    }


    /**
     * Compares the availability of different planets
     * 
     * @param Planet
     *            to be compared to
     * @return -1 if the availability of this planet is less than
     *         the other. 1 if the availability of this planet is greater than
     *         the other. 0 if the availability is the same
     */
    @Override
    public int compareTo(Planet other) {
        if (this.getAvailability() < other.getAvailability()) {
            return -1;
        }
        else if (this.getAvailability() > other.getAvailability()) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
