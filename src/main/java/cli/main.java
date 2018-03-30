package cli;

import business.rules.registration.Register;
import business.rules.registration.BusinessException;

public class main {

    public static void registerOwner(String firstname, String lastname, String email, String password){
        Register register = new Register();
        try {
            register.registerAsOwner(firstname, lastname, email, password);
            System.out.println("Successfully registered");
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] argv){
        registerOwner("test", "test", "test2", "test");

    }

}
