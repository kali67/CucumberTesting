package utilsTesting;

import business.rules.BRRegistrationException;
import org.junit.Assert;
import org.junit.Test;
import utils.Input;

public class InputTest {

    @Test
    public void isNameOnlyCharsTestValid(){
        try {
            Assert.assertEquals(true, Input.isNameOnlyChars("Bob"));
        } catch (BRRegistrationException e){
            Assert.fail();
        }
    }

    @Test(expected = BRRegistrationException.class)
    public void isNameOnlyCharsTestContainsNumbers() throws BRRegistrationException {
        Input.isNameOnlyChars("B0b");
    }

    @Test(expected = BRRegistrationException.class)
    public void isNameOnlyCharsTestContainsSpecialChars() throws BRRegistrationException {
        Input.isNameOnlyChars("B@b_");
    }

    @Test(expected = BRRegistrationException.class)
    public void isCorrectDateFormatTestInvalidDay() throws BRRegistrationException {
        Input.isCorrectDateFormat("39.12.2000");
    }

    @Test(expected = BRRegistrationException.class)
    public void isCorrectDateFormatTestInvalidYear() throws BRRegistrationException {
        Input.isCorrectDateFormat("12.12.20000");
    }

    @Test
    public void isCorrectTestDateFormat(){
        try {
            Assert.assertEquals(true, Input.isCorrectDateFormat("12.12.2000"));
        } catch (BRRegistrationException e){
            Assert.fail();
        }
    }

    @Test
    public void isCorrectTestDateFormatNull(){
        try {
            Assert.assertEquals(true, Input.isCorrectDateFormat(null));
        } catch (BRRegistrationException e){
            Assert.fail();
        }
    }

    @Test(expected = BRRegistrationException.class)
    public void isYearTestTooLarge() throws BRRegistrationException {
        Input.isYear("20000");
    }

    @Test(expected = BRRegistrationException.class)
    public void isYearTestTooSmall() throws BRRegistrationException {
        Input.isYear("200");
    }

    @Test
    public void isYearTestValid() {
        try {
            Assert.assertEquals(true, Input.isYear("2000"));
        } catch (BRRegistrationException e){
            Assert.fail();
        }
    }

    @Test
    public void isYearTestNull() {
        try {
            Assert.assertEquals(true, Input.isYear(null));
        } catch (BRRegistrationException e){
            Assert.fail();
        }
    }

    @Test(expected = BRRegistrationException.class)
    public void isYearTestNotInt() throws BRRegistrationException {
        Input.isYear("wqr");
    }

    @Test
    public void isAFuelTest() {
        try {
            Assert.assertEquals(true, Input.isAFuel("petrol"));
        } catch (BRRegistrationException e){
            Assert.fail();
        }
    }

    @Test(expected = BRRegistrationException.class)
    public void isAFuelTestInvalidFuel() throws BRRegistrationException {
        Input.isAFuel("notafuel");
    }

    @Test
    public void isAFuelTestNull() {
        try {
            Assert.assertEquals(true, Input.isAFuel(null));
        } catch (BRRegistrationException e){
            Assert.fail();
        }
    }

    @Test(expected = BRRegistrationException.class)
    public void isValidPlateTestInvalidPlate() throws BRRegistrationException {
        Input.isValidPlate("ABCDEFG12");
    }

    @Test
    public void isValidPlateTestValid() {
        try {
            Assert.assertEquals(true, Input.isValidPlate("ABC123"));
        } catch (BRRegistrationException e){
            Assert.fail();
        }
    }

    @Test(expected = BRRegistrationException.class)
    public void isValidVinTestTooSmall() throws BRRegistrationException {
        Input.isValidVin("1234567890");
    }

    @Test
    public void isValidVinTestValid() {
        try {
            Assert.assertEquals(true, Input.isValidVin("12345678901234567"));
        } catch (BRRegistrationException e){
            Assert.fail();
        }
    }

    @Test
    public void isValidVinTestNull() {
        try {
            Assert.assertEquals(true, Input.isValidVin(null));
        } catch (BRRegistrationException e){
            Assert.fail();
        }
    }
}
