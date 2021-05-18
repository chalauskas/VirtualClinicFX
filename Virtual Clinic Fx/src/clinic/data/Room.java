package clinic.data;

/**
 * This class contain Room Class
 */
public class Room implements  GetCompletInformation{

    private int number;
    private String description;
    private String specialEquipment;

    /**
     * This is the constructor of the class
     * @param number
     * @param description
     * @param specialEquipment
     */
    public Room(int number, String description, String specialEquipment) {
        this.number = number;
        this.description = description;
        this.specialEquipment = specialEquipment;
    }

    /**
     * The get method of the Number attribute
     * @return
     */
    public int getNumber() {
        return number;
    }

    /**
     * The set method of the Number attribute
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * The get method of the getDescription attribute
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * The set method of the setDescription attribute
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * The get method of the getSpecialEquipment attribute
     * @return
     */
    public String getSpecialEquipment() {
        return specialEquipment;
    }

    /**
     * The set method of the setSpecialEquipment attribute
     * @param specialEquipment
     */
    public void setSpecialEquipment(String specialEquipment) {
        this.specialEquipment = specialEquipment;
    }

    /**
     * An implements function from GetCompleteInformation
     */
    @Override
    public void showAllData() {
        String AllData = "Number: " + number + "\n" + "Description: " + description + "\n" + "Special Equipment: "+ specialEquipment + "\n \n";
        System.out.println("Number: " + number);
        System.out.println("Description: " + description);
        System.out.println("Special Equipment: "+ specialEquipment);
        System.out.println();
        System.out.println();

    }

    /**
     * The ToString method. To take some values of the object.
     * @return
     */
    @Override
    public String toString() {
        return number + "; " + description + "; " + specialEquipment;
    }

    /**
     * A function to show all the Data of the object like we want to show it.
     * @return
     */
    public String allDataToString (){
        return  "Number: " + number + "\n" + "Description: " + description + "\n" + "Special Equipment: "+
                specialEquipment + "\n \n";
    }
}
