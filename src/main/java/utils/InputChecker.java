package utils;

import business.rules.registration.BusinessException;

import java.util.regex.Pattern;

public class InputChecker {

    public static boolean isNameOnlyChars(String name) throws BusinessException {
        if (Pattern.matches("([A-Z])\\w+", name)){
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

}
