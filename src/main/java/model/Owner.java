package model;

public class Owner {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    /**
     * Constructor of an owner object
     * @param firstname - first name of the owner
     * @param lastname - last name of the owner
     * @param email - email address of the owner
     * @param password - password of the owner
     */
    public  Owner(String firstname, String lastname, String email, String password){
        this.firstName = firstname;
        this.lastName = lastname;
        this.email = email;
        this.password = password;
    }

    /**
     * @param obj - object for comparision
     * @return - return true if objects are considered equal
     */
    @Override
    public boolean equals (Object obj){
        Owner owner = (Owner) obj;
        return owner.firstName.equals(this.firstName) &&
                owner.lastName.equals(this.lastName) && owner.email.equals(this.email) &&
                owner.password.equals(this.password);
    }
}
