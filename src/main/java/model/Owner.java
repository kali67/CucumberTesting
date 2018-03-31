package model;

public class Owner {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    /**
     * @param firstname
     * @param lastname
     * @param email
     * @param password
     */
    public  Owner(String firstname, String lastname, String email, String password){
        this.firstName = firstname;
        this.lastName = lastname;
        this.email = email;
        this.password = password;
    }

    /**
     * @return
     */
    @Override
    public String toString(){
        return String.format("Firstname: %s\nLastname:%s\nEmail:%s", firstName,lastName,email);
    }

    /**
     * @param obj
     * @return
     */
    @Override
    public boolean equals (Object obj){
        Owner owner = (Owner) obj;
        return owner.firstName.equals(this.firstName) &&
                owner.lastName.equals(this.lastName) && owner.email.equals(this.email) &&
                owner.password.equals(this.password);
    }
}
