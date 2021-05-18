package clinic.fx;

import clinic.data.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller  implements Initializable{
    public TextArea textArea_Data;

    @FXML
    private ListView<Client> listView_Clients;
    @FXML
    private TextField textF_DNI;
    @FXML
    private TextField textF_Name;
    @FXML
    private TextField textF_LastName;
    @FXML
    private TextField textF_Telephone;
    @FXML
    private TextField textF_AnimalName;
    @FXML
    private TextField textF_Specie;
    @FXML
    private TextField textF_Race;
    @FXML
    private ComboBox<String> combobox_ShowData;
    @FXML
    private ArrayList<Room> clinicRooms;
    private ArrayList<PermanentEmployee> pEmployees;
    private ArrayList<Client> clients = new ArrayList<>();
    private ArrayList<Animal> allAnimalsList = new ArrayList<>();
    private int numberAnimal = 0;
    private int numberClient = 0;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        combobox_ShowData.getItems().addAll("Rooms", "Permanent Employees", "Temporary Employees", "Clients", "Animals");

        clinicRooms = new ArrayList<>();
        clinicRooms.add(new Room(1,"Examination Room 1", "None"));
        clinicRooms.add(new Room(2,"Examination Room 2", "None"));
        clinicRooms.add(new Room(3,"Radiology", "X ray machine, ultrasound"));
        clinicRooms.add(new Room(4,"Operating Room", "Sterilizer"));
        clinicRooms.add(new Room(5,"Reanimation Room 1", "None"));
        clinicRooms.add(new Room(6,"Reanimation Room 2", "None"));
        clinicRooms.add(new Room(7,"Exotic Animals Room", "None"));

        pEmployees = new ArrayList<>();
        pEmployees.add(new PermanentEmployee("Peter", "Queen", "555-698-874", "72000965L",
                "Surgeon", "PE001", "01-01-2000", clinicRooms.get(3)));
        pEmployees.add(new PermanentEmployee("John", "Taylor", "555-654-321", "36987452G",
                "Exotic Specialist", "PE002", "26-10-2012", clinicRooms.get(6)));
        pEmployees.add(new PermanentEmployee("Mary", "Sanders", "555-333-147", "258789456H",
                "General Veterinary", "PE003", "26-03-2018", clinicRooms.get(0)));
        pEmployees.add(new PermanentEmployee("Steve", "Williams", "555-333-145", "587456321G",
                "General Veterinary", "PE004", "09-06-2019", clinicRooms.get(1)));
        pEmployees.add(new PermanentEmployee("Marty", "McFly", "555-996-478", "215698453F",
                "Veterinary Aux.", "PE005", "26-11-2007", clinicRooms.get(4)));
        pEmployees.add(new PermanentEmployee("Greg", "Callen", "555-111-854", "745698213T",
                "Veterinary Aux.", "PE006", "28-02-2019", clinicRooms.get(5)));
        pEmployees.add(new PermanentEmployee("William", "Straus", "555-264-123", "365412789Q",
                "Radiologist", "PE007", "30-01-2020", clinicRooms.get(2)));

        allAnimalsList = new ArrayList<>();

        if((new File("status.dat")).exists()){
            BufferedReader inputFile = null;
            try{
                inputFile = new BufferedReader(new FileReader("status.dat"));
                String line = inputFile.readLine();
                List<String> clientsData = new ArrayList<>();
                while(line != null){
                    clientsData.add(line);
                    line= inputFile.readLine();
                }
                for (String c : clientsData){
                    ArrayList<Animal> animalList = new ArrayList<>();
                    String [] clientsParts = c.split(";");
                    int numberOfAnimals = Integer.parseInt(clientsParts[5]);
                    String [] animalsParts = c.split("\\[");
                    String [] allAnimalsListParts = animalsParts[1].split(",");
                    for(int i = 0 ; i < numberOfAnimals; i++){
                        String [] animalsDataSplit = allAnimalsListParts[i].split("#");
                        String id = animalsDataSplit[1];
                        String name = animalsDataSplit[2];
                        String specie = animalsDataSplit[3];
                        String race = animalsDataSplit[4];
                        Animal a = new Animal(name,id, specie,race);
                        animalList.add(a);
                        allAnimalsList.add(a);

                        numberAnimal++;
                    }
                    String clientName = clientsParts[0];
                    String lastName = clientsParts[1];
                    String telephone = clientsParts[2];
                    String dni = clientsParts[3];
                    String idClient = clientsParts[4];
                    Client loadClient = new Client(clientName,lastName,telephone,dni,idClient,animalList);
                    clients.add(loadClient);
                    numberClient++;
                    listView_Clients.getItems().add(loadClient);
                }
            }
            catch (IOException e){
                System.err.println("Error reading file");
            }
            finally{
                try {
                    inputFile.close();
                } catch (IOException e) {

                }
            }
        }
    }

    public void addRegister(ActionEvent actionEvent) {
        boolean exist = false;
        numberAnimal ++;
        String numAnimal = "AID" + numberAnimal;

        String dni = textF_DNI.getText();
        String name = textF_Name.getText();
        String lastName = textF_LastName.getText();
        String telephone = textF_Telephone.getText();
        String animalName = textF_AnimalName.getText();
        String specie = textF_Specie.getText();
        String race = textF_Race.getText();

        Animal a = new Animal(animalName,numAnimal,specie,race);
        allAnimalsList.add(a);

        if (clients.size() == 0) {
            List<Animal> animals = new ArrayList<>();
            animals.add(a);

            numberClient++;
            String numClient = "CID" + numberClient;

            Client newC = new Client(name,lastName,telephone,dni,numClient,animals);

            clients.add(newC);
            listView_Clients.getItems().add(newC);
        }
        else {
            for (Client c : clients) {
                if (c.getDni().equals(dni)) {
                    List<Animal> updateList = c.updateAnimals(a);
                    c.setAnimal(updateList);
                    exist = true;
                }
            }
            if (!exist){
                List<Animal> animals = new ArrayList<>();
                animals.add(a);

                numberClient++;
                String numClient = "CID" + numberClient;

                Client newC = new Client(name, lastName, telephone, dni, numClient, animals);

                clients.add(newC);
                listView_Clients.getItems().add(newC);
            }

        }
    }

    public void cB_ShowDataAction(ActionEvent actionEvent) {
        String choice = combobox_ShowData.getSelectionModel().getSelectedItem();
        if (choice.equals("Rooms")) {
            String allRooms = "";
            for (Room r : clinicRooms) {
                allRooms = allRooms + r.allDataToString() + "\n";
                textArea_Data.setText(allRooms);
            }
        }
        if (choice.equals("Permanent Employees")) {
            String allPermanentEmployees = "";
            for (PermanentEmployee pE : pEmployees) {
                allPermanentEmployees = allPermanentEmployees + pE.allDataToString() + "\n";
                textArea_Data.setText(allPermanentEmployees);
            }

        }
        if (choice.equals("Temporary Employees")) {
            textArea_Data.setText("Not Data Found");
        }
        if (choice.equals("Clients")) {
            String allClients = "";
            for (Client c : clients) {
                allClients = allClients + c.allDataToString() + "\n";
                textArea_Data.setText(allClients);
            }
        }
        if (choice.equals("Animals")) {
            String allAnimals = "";
            for (Animal a : allAnimalsList) {
                allAnimals = allAnimals + a.allDataToString() + "\n";
                textArea_Data.setText(allAnimals);
            }
        }
    }

    public void CompletRegister(ActionEvent actionEvent) {
        String dni = textF_DNI.getText();
        for (Client c : clients) {
            if (c.getDni().equals(dni)) {
                textF_Name.setText(c.getName());
                textF_LastName.setText(c.getLastName());
                textF_DNI.setText(c.getDni());
                textF_Telephone.setText(c.getTelephone());
            }
        }
    }

    public void save(ActionEvent actionEvent) {
        PrintWriter pw = null;
        try{
            pw = new PrintWriter("status.dat");
            for(int i = 0; i < clients.size(); i++){
                pw.println(clients.get(i).saveDataString());
            }
        }
        catch (FileNotFoundException e){
            System.err.println("Error writing file");
        }
        finally {
            if(pw != null)
                pw.close();
        }
    }
}



