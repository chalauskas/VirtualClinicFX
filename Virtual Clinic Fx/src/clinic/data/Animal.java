package clinic.data;

/**
 * This class contain Animal Class
 */
public class Animal implements  GetCompletInformation{

    private String name;
    private String identificationID;
    private String specie;
    private String race;

    /**
     * This is the constructor of the class
     * @param name
     * @param identificationID
     * @param specie
     * @param race
     */
    public Animal(String name, String identificationID, String specie, String race) {
        this.name = name;
        this.identificationID = identificationID;
        this.specie = specie;
        this.race = race;
    }

    /**
     * The get method of the Name attribute
     * @return string (name)
     */
    public String getName() {
        return name;
    }

    /**
     * the set method of de Name attribute
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The get method of the IdIdentification attribute
     * @return string (idIdentification)
     */
    public String getIdentificationID() {
        return identificationID;
    }

    /**
     * the set method of de IdIdentification attribute
     * @param identificationID
     */
    public void setIdentificationID(String identificationID) {
        this.identificationID = identificationID;
    }

    /**
     * The get method of the Specie attribute
     * @return String(Specie)
     */
    public String getSpecie() {
        return specie;
    }

    /**
     * The set method of de Specie attribute
     * @param specie
     */
    public void setSpecie(String specie) {
        this.specie = specie;
    }

    /**
     * The get method of the Race attribute
     * @return String(Race)
     */
    public String getRace() {
        return race;
    }

    /**
     * The set method of de Race attribute
     * @param race
     */
    public void setRace(String race) {
        this.race = race;
    }

    /**
     * An implements function from GetCompleteInformation
     */
    @Override
    public void showAllData() {
        System.out.println("Name: " +name);
        System.out.println("Number of ID: " +identificationID);
        System.out.println("Specie: " +specie);
        System.out.println("Race: " + race);
        System.out.println();
        System.out.println();
    }

    /**
     * The ToString method. To take some values of the object.
     * @return String
     */
    @Override
    public String toString() {
        return  "#" + identificationID + "#" + name + "#" + specie + "#" + race + "#";
    }

    /**
     * A function to show all the Data of the object like we want to show it.
     * @return String
     */
    public String allDataToString () {
        return "Animal ID: " + identificationID + "\n" + "Name: " + name + " " + "\n" + "Specie: " + specie + "\n" + "Race: " +
                race + "\n \n";
    }
}
