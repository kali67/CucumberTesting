package utils;

import BR.registration.BusinessException;

import java.util.regex.Pattern;

public class Input {

    public static boolean isNameOnlyChars(String name) throws BusinessException {
        if (Pattern.matches("^[a-zA-Z ]*$", name)){
            return true;
        }
        throw new BusinessException("Invalid name");
    }

    public static boolean isCorrectDateFormat(String date) throws BusinessException{
        if ( (date == null|| date.equals("")) ||
                Pattern.matches("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$", date)){
            return true;
        }
        throw new BusinessException("Invalid date format");
    }

    public static boolean isYear(String year) throws BusinessException{
        if (year == null || tryParseInt(year)){
            if (year == null || (Integer.parseInt(year) >= 1900 && Integer.parseInt(year) <= 2020)){
                return true;
            }
        }
        throw new BusinessException("Invalid year");
    }

    public static boolean isAFuel(String fuel) throws BusinessException{
        if (fuel == null || GlobalEnums.Fuel.getEnumFromString(fuel) != null){
            return true;
        }
        throw new BusinessException("Invalid fuel type");
    }


    private static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidPlate(String plate) throws BusinessException{
        if (plate.length() <= 6){
            return true;
        }
        throw new BusinessException("Invalid vehicle plate");
    }

    public static boolean isValidVin(String vin) throws BusinessException{
        if (vin == null || vin.length() == 17){
            return true;
        }
        throw new BusinessException("Invalid vin number");
    }
}
