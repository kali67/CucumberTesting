package model;

public class Owner {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public  Owner(String firstname, String lastname, String email, String password){
        this.firstName = firstname;
        this.lastName = lastname;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return String.format("Firstname: %s\nLastname:%s\nEmail:%s", firstName,lastName,email);
    }


    @Override
    public boolean equals (Object obj){
        Owner owner = (Owner) obj;
        return owner.firstName.equals(this.firstName) &&
                owner.lastName.equals(this.lastName) && owner.email.equals(this.email) &&
                owner.password.equals(this.password);
    }
}
