package application;

import services.DataAccess;

public class main {

    public static void main(String[] argv){
        DataAccess.restoreDB(); //restore DB before each run
        Example exampleApp = new Example();
        exampleApp.registerJoe();
        exampleApp.registerVehicleToJoe();
        exampleApp.registerJoeTwice();
        exampleApp.registerVehicleWithInvalidEmail();
    }

}
