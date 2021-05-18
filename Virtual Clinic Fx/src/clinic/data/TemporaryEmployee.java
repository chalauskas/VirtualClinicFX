package clinic.data;

import java.util.List;

/**
 * This class contain TemporaryEmployee Class
 */
public class TemporaryEmployee extends Employee implements GetCompletInformation{

    private String temporaryEmployeeID;
    private List<String> contractedPeriods;

    /**
     * This is the constructor of the class
     * @param name
     * @param lastName
     * @param telephone
     * @param dni
     * @param category
     * @param temporaryEmployeeID
     * @param contractedPeriods
     */
    public TemporaryEmployee(String name, String lastName, String telephone, String dni, String category,
                             String temporaryEmployeeID, List<String> contractedPeriods) {
        super(name, lastName, telephone, dni, category);
        this.temporaryEmployeeID = temporaryEmployeeID;
        this.contractedPeriods = contractedPeriods;
    }

    /**
     * The get method of the getTemporaryEmployeeID attribute
     * @return
     */
    public String getTemporaryEmployeeID() {
        return temporaryEmployeeID;
    }

    /**
     * The set method of the getTemporaryEmployeeID attribute
     * @param temporaryEmployeeID
     */
    public void setTemporaryEmployeeID(String temporaryEmployeeID) {
        this.temporaryEmployeeID = temporaryEmployeeID;
    }

    /**
     * The get method of the getContractedPeriods attribute
     * @return
     */
    public List<String> getContractedPeriods() {
        return contractedPeriods;
    }

    /**
     * The set method of the setContractedPeriods attribute
     * @param contractedPeriods
     */
    public void setContractedPeriods(List<String> contractedPeriods) {
        this.contractedPeriods = contractedPeriods;
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
        System.out.println("Employee ID: " + temporaryEmployeeID);
        System.out.println("Contracted Periods: ");
        for(String s: contractedPeriods)
            System.out.println(s);
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
                temporaryEmployeeID + "; " + contractedPeriods;
    }

    /**
     * A function to show all the Data of the object like we want to show it.
     * @return
     */
    public String allDataToString () {
        return "Worker ID: " + temporaryEmployeeID + "\n" + "Name: " + name + " " + lastName + "\n" + "Telephone: " + telephone + "\n" + "DNI: " +
                dni + "\n" + "Category: " + category + "\n" + "Contract periods: " + contractedPeriods + "\n \n";
    }
}


