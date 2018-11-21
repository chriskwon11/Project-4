package spacecolonies;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import bsh.ParseException;

/**
 * Parses the data form the two text files. Each input file pertains
 * to either the planets or the queue of applicants. These files are
 * read and stored in an array and arrayQueue for the SpaceWindow
 * 
 * @author ckbbe
 *
 */
public class ColonyReader {
    private Planet[] planets;
    private ArrayQueue<Person> queue;


    /**
     * Reads the two files passed in as strings and stores
     * them in their respective data structures.
     * 
     * @param applicantFileName
     *            File name for applicants
     * @param planetFileName
     *            File name for planet file
     * @throws ParseException
     * @throws IOException
     * @throws SpaceColonyDataException
     */
    public ColonyReader(String applicantFileName, String planetFileName)
        throws ParseException,
        IOException,
        SpaceColonyDataException {
        planets = readPlanetFile(planetFileName);
        queue = readQueueFile(applicantFileName);
    }


    /**
     * Reads the planet file. Parses the text file and creates
     * new planets and stores them in an array
     * 
     * @param fileName
     *            Name of the file
     * @return Array of planets
     * @throws IOException
     * @throws SpaceColonyDataException
     * @throws ParseException
     */
    private Planet[] readPlanetFile(String fileName)
        throws IOException,
        SpaceColonyDataException,
        ParseException {
        Planet[] planets = new Planet[ColonyCalculator.NUM_PLANETS];
        @SuppressWarnings("resource")
        Scanner file = new Scanner(new File(fileName));
        int planetIndex = 0;
        while (file.hasNextLine()) {
            String fileLine = file.nextLine();
            String[] planetInfo = fileLine.split(", *");
            if (planetInfo.length != 5) {
                throw new ParseException();
            }
            if (!this.isInSkillRange(Integer.valueOf(planetInfo[1]), Integer
                .valueOf(planetInfo[2]), Integer.valueOf(planetInfo[3]))) {
                throw new SpaceColonyDataException("Skills not betwen 1 and 5");
            }
            Planet planet = new Planet(planetInfo[0], Integer.valueOf(
                planetInfo[1]), Integer.valueOf(planetInfo[2]), Integer.valueOf(
                    planetInfo[3]), Integer.valueOf(planetInfo[4]));
            planets[planetIndex] = planet;
            planetIndex++;
        }
        if (planetIndex != 3) {
            throw new SpaceColonyDataException("Less than 3 planets");
        }
        return planets;
    }


    /**
     * Reads the queue file. Parses the text file, creating new
     * people and storing them in an ArrayQueue.
     * 
     * @param fileName
     *            Name of the file
     * @return ArrayQueue of object person
     * @throws IOException
     * @throws SpaceColonyDataException
     * @throws ParseException
     */
    private ArrayQueue<Person> readQueueFile(String fileName)
        throws IOException,
        SpaceColonyDataException {
        ArrayQueue<Person> people = new ArrayQueue<Person>();
        @SuppressWarnings("resource")
        Scanner file = new Scanner(new File(fileName));
        while (file.hasNextLine()) {
            String fileLine = file.nextLine();
            String[] peopleInfo = fileLine.split(", *");
            if (!this.isInSkillRange(Integer.valueOf(peopleInfo[1]), Integer
                .valueOf(peopleInfo[2]), Integer.valueOf(peopleInfo[3]))) {
                throw new SpaceColonyDataException("Skills not betwen 1 and 5");
            }
            Person person = null;
            if (peopleInfo.length == 4) {
                person = new Person(peopleInfo[0], Integer.valueOf(
                    peopleInfo[1]), Integer.valueOf(peopleInfo[2]), Integer
                        .valueOf(peopleInfo[3]), "");
            }
            else {
                person = new Person(peopleInfo[0], Integer.valueOf(
                    peopleInfo[1]), Integer.valueOf(peopleInfo[2]), Integer
                        .valueOf(peopleInfo[3]), peopleInfo[4]);
            }
            people.enqueue(person);

        }
        return people;
    }


    /**
     * Checks if the inputed skills are in the range 1 to 5
     * 
     * @param num1
     *            Skill 1
     * @param num2
     *            Skill 2
     * @param num3
     *            Skill 3
     * @return True if in range, and false otherwise
     */
    private boolean isInSkillRange(int num1, int num2, int num3) {
        return (num1 <= ColonyCalculator.MAX_SKILL_LEVEL
            && num1 >= ColonyCalculator.MIN_SKILL_LEVEL)
            && (num2 <= ColonyCalculator.MAX_SKILL_LEVEL
                && num2 >= ColonyCalculator.MIN_SKILL_LEVEL)
            && (num3 <= ColonyCalculator.MAX_SKILL_LEVEL
                && num3 >= ColonyCalculator.MIN_SKILL_LEVEL);
    }


    public Planet[] getPlanets() {
        return planets;
    }


    public ArrayQueue<Person> getQueue() {
        return queue;
    }
}
