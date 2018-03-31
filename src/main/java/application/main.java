package application;

public class main {

    public static void main(String[] argv){
        Registration r = new Registration();
        r.registerOwner("Test", "Test", "hayde222222222222222@gmail.com", "test");
        r.registerVehicle("hayde222222222222222@gmail.com", "222", "model", "make", null,
                "petrol", null, null, null, null);
    }

}
