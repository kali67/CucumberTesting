package application;

import utils.Output;

class Example {
    private Registration registration;

     Example(){
        registration = new Registration();
    }

    /**
     * Register an owner, with correct details
     */
    void registerJoe(){
        Output.print("*** Registration of owner Joe Bloggs ***"); //redirected sys.out
        registration.registerOwner("Joe", "Bloggs", "example@example.com", "passw0rd");
        Output.print("\n");
    }

    /**
     * Register a vehicle to Joe, with the correct details
     */
    void registerVehicleToJoe(){
        Output.print("*** Registration of vehicle to Joe Bloggs ***");
        registration.registerVehicle("example@example.com", "DQW123", "Levin",
                "Toyota", "12.12.1998", "Petrol", "12345678901234567", "123412",
                "2018","12.12.2018");
        Output.print("\n");
    }

    /**
     * register owner with an already registered email
     */
    void registerJoeTwice(){
        Output.print("*** Registration of owner Joe Bloggs with email thats already registered ***");
        registration.registerOwner("Joe", "Bloggs", "example@example.com", "passw0rd");
        Output.print("\n");
    }


    /**
     * register a vehicle with an email address that isnt registered
     */
    void registerVehicleWithInvalidEmail(){
        Output.print("*** Registration of a vehicle to an email address that is not registered yet ***");
        registration.registerVehicle("not@registered.com", "DQW123", "Levin",
                "Toyota", "12.12.1998", "Petrol", "12345678901234567", "123412",
                "2018","12.12.2018");
        Output.print("\n");
    }
}
