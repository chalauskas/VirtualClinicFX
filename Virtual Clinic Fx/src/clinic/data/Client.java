package clinic.data;


import java.util.ArrayList;
import java.util.List;

/**
 * This class contains Client class inherit from Class Person
 */
public class Client  extends Person implements GetCompletInformation{

    private String clientID;
    private List<Animal> animal;

    /**
     * The constructor of the class
     * @param name
     * @param lastName
     * @param telephone
     * @param dni
     * @param clientID
     * @param animal
     */
    public Client(String name, String lastName, String telephone, String dni, String clientID, List<Animal> animal) {
        super(name, lastName, telephone, dni);
        this.clientID = clientID;
        this.animal = animal;
    }

    /**
     * The get method of the ClientID attribute
     * @return String (ClientID)
     */
    public String getClientID() {
        return clientID;
    }

    /**
     * The set method of the ClientID attribute
     * @param clientID
     */
    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    /**
     * The get method of the Animal list attribute
     * @return
     */
    public List<Animal> getAnimal() {
        return animal;
    }

    /**
     * The set method of the Animal list attribute
     * @param animal
     */
    public void setAnimal(List<Animal> animal) {
        this.animal = animal;
    }

    /**
     * An implements function from GetCompletInformation
     */
    @Override
    public void showAllData() {
        System.out.println("Name: " + lastName + ", " + name);
        System.out.println("Telephone number: " + telephone);
        System.out.println("DNI: " + dni);
        System.out.println("Client ID: " + clientID);
        System.out.println("Animals: ");
        for(Animal a: animal)
            System.out.println(a);
        System.out.println();
        System.out.println();
    }

    /**
     * A function to update the list of Animals when the client still exist.
     * @param newAnimal
     * @return
     */
    public List<Animal> updateAnimals(Animal newAnimal){
        List<Animal> updateList = new ArrayList<>();
        for(Animal a : animal)
            updateList.add(a);
        updateList.add(newAnimal);

        return updateList;
    }

    /**
     * The ToString method. To take some values of the object.
     * @return
     */
    @Override
    public String toString() {
        return  clientID + ": " + name + " " + lastName;
    }

    /**
     * A function to show all the Data of the object like we want to show it.
     * @return
     */
    public String allDataToString (){
        return  "Client ID: " + clientID + "\n" + "Name: " + name + " " + lastName + "\n" + "Telephone: " + telephone + "\n" + "DNI: "+
                dni +  "\n \n";
    }

    /**
     * Specific function to load/save data
     * @return
     */
    public String saveDataString(){
        return  name + ";" + lastName + ";" + telephone + ";" + dni + ";" + clientID + ";" + animal.size() + ";" + animal;
    }

}
