package clinic.data;

public abstract class Employee extends Person {

    protected String category;

    public Employee(String name, String lastName, String telephone, String dni, String category) {
        super(name, lastName, telephone, dni);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
