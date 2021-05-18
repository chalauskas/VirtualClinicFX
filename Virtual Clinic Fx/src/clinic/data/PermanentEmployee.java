package clinic.data;

/**
 * This class contain PermanentEmployee Class
 */
public class PermanentEmployee extends Employee implements  GetCompletInformation{

    private String permanentEmployeeID;
    private String dateOfIncorporation;
    private Room room;

    /**
     * This is the constructor of the class
     * @param name
     * @param lastName
     * @param telephone
     * @param dni
     * @param category
     * @param permanentEmployeeID
     * @param dateOfIncorporation
     * @param room
     */
    public PermanentEmployee(String name, String lastName, String telephone, String dni, String category,
                             String permanentEmployeeID, String dateOfIncorporation, Room room) {
        super(name, lastName, telephone, dni, category);
        this.permanentEmployeeID = permanentEmployeeID;
        this.dateOfIncorporation = dateOfIncorporation;
        this.room = room;
    }

    /**
     * The get method of the PermanentEmployeeID attribute
     * @return
     */
    public String getPermanentEmployeeID() {
        return permanentEmployeeID;
    }

    /**
     * The set method of the PermanentEmployeeID attribute
     * @param permanentEmployeeID
     */
    public void setPermanentEmployeeID(String permanentEmployeeID) {
        this.permanentEmployeeID = permanentEmployeeID;
    }

    /**
     * The get method of the getDateOfIncorporation attribute
     * @return
     */
    public String getDateOfIncorporation() {
        return dateOfIncorporation;
    }

    /**
     * The set method of the getDateOfIncorporation attribute
     * @param dateOfIncorporation
     */
    public void setDateOfIncorporation(String dateOfIncorporation) {
        this.dateOfIncorporation = dateOfIncorporation;
    }

    /**
     * The get method of the Room attribute
     * @return
     */
    public Room getRoom() {
        return room;
    }

    /**
     * The set method of the Room attribute
     * @param room
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * An implements function from GetCompleteInformation
     */
    @Override
    public void showAllData() {
        System.out.println("Name: " + lastName + ", " + name);
        System.out.println("Telephone number: " + telephone);
        System.out.println("DNI: " + dni);
        System.out.println("Category: " + category);
        System.out.println("Employee ID: " + permanentEmployeeID);
        System.out.println("Date of Incorporation: " + dateOfIncorporation);
        System.out.println("Room assigned: " + room);
        System.out.println();
        System.out.println();
    }

    /**
     * The ToString method. To take some values of the object.
     * @return
     */
    @Override
    public String toString() {
        return  name+  "; " + lastName + "; " + telephone + "; " + dni + "; " + category + "; " +
                permanentEmployeeID + "; " + dateOfIncorporation + "; " + room;
    }

    /**
     * A function to show all the Data of the object like we want to show it.
     * @return
     */
    public String allDataToString (){
        return  "Worker ID: " + permanentEmployeeID + "\n" + "Name: " + name + " " + lastName + "\n" + "Telephone: " + telephone + "\n" + "DNI: "+
                dni + "\n" + "Category: " + category + "\n" + "Date of incorporation: " + dateOfIncorporation +  "\n \n";
    }
}

