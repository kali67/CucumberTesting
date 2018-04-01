package utils;

import business.rules.BRRegistrationException;

import java.util.regex.Pattern;

public class Input {

    /**
     * Checks if the input string is A_Z characters only
     * @param name - string to be checked
     * @return true - if correctly formatted
     * @throws BRRegistrationException - thrown if not formatted correctly
     */
    public static boolean isNameOnlyChars(String name) throws BRRegistrationException { //throw to BR layer
        if (Pattern.matches("^[a-zA-Z ]*$", name)){
            return true;
        }
        throw new BRRegistrationException("Invalid name");
    }

    /**
     * Checks if date is in the correct format (dd/mm/yyyy)
     * @param date - string to be checked
     * @return true - if correctly formatted
     * @throws BRRegistrationException - thrown if not formatted correctly
     */
    public static boolean isCorrectDateFormat(String date) throws BRRegistrationException {
        if ( (date == null|| date.equals("")) ||
                Pattern.matches("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$", date)){
            return true;
        }
        throw new BRRegistrationException("Invalid date format");
    }

    /**
     * Checks if the input given is a valid year (not too small/large)
     * @param year - string to be checked
     * @return true - if correctly formatted
     * @throws BRRegistrationException - thrown if not formatted correctly
     */
    public static boolean isYear(String year) throws BRRegistrationException {
        if (year == null || tryParseInt(year)){
            if (year == null || (Integer.parseInt(year) >= 1900 && Integer.parseInt(year) <= 2020)){
                return true;
            }
        }
        throw new BRRegistrationException("Invalid year");
    }

    /**
     * Checks if the given string is a valid fuel type
     * @param fuel - string to be checked
     * @return true - if correctly formatted
     * @throws BRRegistrationException - thrown if not formatted correctly
     */
    public static boolean isAFuel(String fuel) throws BRRegistrationException {
        if (fuel == null || GlobalEnums.Fuel.getEnumFromString(fuel) != null){
            return true;
        }
        throw new BRRegistrationException("Invalid fuel type");
    }


    /**
     * Trys to parse string to int
     * @param value - string to be checked
     * @return true - if can be parsed to an int
     */
    private static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Checks to see if the plate given is a valid plate (<=6)
     * @param plate - string to be checked
     * @return true - if correctly formatted
     * @throws BRRegistrationException - thrown if not formatted correctly
     */
    public static boolean isValidPlate(String plate) throws BRRegistrationException {
        if (plate.length() <= 6){
            return true;
        }
        throw new BRRegistrationException("Invalid vehicle plate");
    }

    /**
     * Check if the vin provided is of valid length (=17)
     * @param vin - string to be checked
     * @return true - if correctly formatted
     * @throws BRRegistrationException - thrown if not formatted correctly
     */
    public static boolean isValidVin(String vin) throws BRRegistrationException {
        if (vin == null || vin.length() == 17){
            return true;
        }
        throw new BRRegistrationException("Invalid vin number");
    }
}
