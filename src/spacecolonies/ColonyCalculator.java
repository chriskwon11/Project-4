package spacecolonies;

import java.util.Arrays;
import list.AList;

/**
 * Executes the calculations for the program. Contains the logic
 * for accepting and rejecting applicants from the queue. To do
 * so it contains an arrayQueue of people and an array of planets
 * 
 * @author ckbbe
 *
 */
public class ColonyCalculator {
    public static final int NUM_PLANETS = 3;
    public static final int MIN_SKILL_LEVEL = 1;
    public static final int MAX_SKILL_LEVEL = 5;
    private ArrayQueue<Person> applicantQueue;
    private AList<Person> rejectBus;
    private static Planet[] planets = new Planet[NUM_PLANETS + 1];


    /**
     * Creates a new ColonyCalculator with an ArrayQueue of applicants and
     * array of planets as parameters. If the queue is null then an exception
     * is thrown, if not then the parameters are set as fields.
     * 
     * @param queue
     *            The queue of applicants
     * @param planets
     *            An array of planets
     */
    public ColonyCalculator(ArrayQueue<Person> queue, Planet[] planets) {
        if (queue == null) {
            throw new IllegalArgumentException();
        }
        applicantQueue = queue;
        ColonyCalculator.planets = planets;
    }


    /**
     * Determines if an applicant can be accepted to a planet. If the applicant
     * has no preference for planet, the applicant will be added to where it is
     * most available. 
     * @param nextPerson
     * @return
     */
    public Planet getPlanetForPerson(Person nextPerson) {
        if (nextPerson == null) {
            return null;
        }
        Planet planetPref = this.getPreferredPlanet(nextPerson);
        // Case where the person has no preferred planet
        if (planetPref == null) {
            for (int i = 0; i < this.NUM_PLANETS; i++) {
                Planet planet = this.getMostAvailablePlanet(i);
                if (!planet.isFull() && planet.isQualified(nextPerson)) {
                    return planet;
                }
            }
            return null;
        }
        // Preferred planet accepted
        else if (planetPref != null && !planetPref.isFull() && planetPref
            .isQualified(nextPerson)) {
            return planetPref;
        }
        // Preferred planet rejected
        else {
            return null;
        }
    }

    /**
     * Attempts to accept the next applicant. If the queue is not empty and 
     * the applicant has a valid planet to move to, then the applicant is 
     * added to the planet and dequeued from the queue.
     * @return True if accepted and false if rejected or the queue is empty
     */
    public boolean accept() {
        if (!applicantQueue.isEmpty()) {
            Planet prefPlanet = this.getPlanetForPerson(applicantQueue
                .getFront());
            if (prefPlanet != null) {
                prefPlanet.addPerson(applicantQueue.getFront());
                return true;
            }
            applicantQueue.dequeue();
            return false;
        }
        return false;
    }

    /**
     * Dequeues the next applicant and adds this applicant to
     * the rejectBus list.
     */
    public void reject() {
        rejectBus.add(applicantQueue.dequeue());
    }


    /**
     * Returns the planet associated with the given numbers
     * (1, 2, and 3). For any other number null is returned
     * 
     * @param planetInt
     *            The integer representation of the planet
     * @return The planet associated with the integer representation, null
     *         if invalid integer
     */
    public Planet planetByNumber(int planetInt) {
        if (planetInt == 1) {
            return planets[0];
        }
        else if (planetInt == 2) {
            return planets[1];
        }
        else if (planetInt == 3) {
            return planets[2];
        }
        else {
            return null;
        }
    }


    /**
     * Returns the integer representation of the planet
     * with the given name planetName
     * 
     * @param planetName
     *            Name of the planet
     * @return Integer representation of the planet with name planetName
     */
    public int getPlanetIndex(String planetName) {
        for (int i = 1; i <= this.NUM_PLANETS; i++) {
            if (planetName == planetByNumber(i).getName()) {
                return i;
            }
        }
        return 0;
    }


    /**
     * Returns the applicant queue
     * 
     * @return Queue of applicants
     */
    public ArrayQueue<Person> getQueue() {
        return applicantQueue;
    }


    /**
     * Return the array of planets
     * 
     * @return Array of planets
     */
    public Planet[] getPlanets() {
        return planets;
    }


    /**
     * Returns the preferred planet of the specified person.
     * Returns null if the person doesn't have a valid preferred planet
     * or if they don't have a preferred planet
     * 
     * @param person
     *            Return this person's preferred planet
     * @return Person's preferred planet if valid, null otherwise
     */
    private Planet getPreferredPlanet(Person person) {
        String planetPref = person.getPlanetName();
        for (Planet planet : planets) {
            if (planet.getName() == planetPref) {
                return planet;
            }
        }
        return null;
    }


    /**
     * Sorts the planets based on availability from most available
     * to least available. The index specifies which planet to retrieve
     * from this sorted array of planets.
     * 
     * @param index
     *            If 0, most available, 1, second most available, 2, least
     *            available
     * @return The planet specified from the sorted array of planets
     */
    private Planet getMostAvailablePlanet(int index) {
        Planet[] sortedPlanets = planets.clone();
        Arrays.sort(sortedPlanets);
        return sortedPlanets[index];
    }
}
