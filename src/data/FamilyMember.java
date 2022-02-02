package data;

public class FamilyMember {
    private int id;
    private String firstName;
    private String lastName;

    public FamilyMember() {

    }

    public FamilyMember(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName =  firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        return "ID = " + this.id + ", first name = " + this.firstName + ", last name = " + this.lastName + ".";
    }

}
