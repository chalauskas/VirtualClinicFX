package clinic.data;

public class Person {
    protected String name;
    protected String lastName;
    protected String telephone;
    protected String dni;

    public Person(String name, String lastName, String telephone, String dni) {
        this.name = name;
        this.lastName = lastName;
        this.telephone = telephone;
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
