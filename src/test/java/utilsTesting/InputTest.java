package utilsTesting;

import BR.registration.BusinessException;
import org.junit.Assert;
import org.junit.Test;
import utils.Input;

public class InputTest {

    @Test
    public void isNameOnlyCharsTestValid(){
        try {
            Assert.assertEquals(true, Input.isNameOnlyChars("Bob"));
        } catch (BusinessException e){
            Assert.fail();
        }
    }

    @Test(expected = BusinessException.class)
    public void isNameOnlyCharsTestContainsNumbers() throws BusinessException{
        Input.isNameOnlyChars("B0b");
    }

    @Test(expected = BusinessException.class)
    public void isNameOnlyCharsTestContainsSpecialChars() throws BusinessException{
        Input.isNameOnlyChars("B@b_");
    }

    @Test(expected = BusinessException.class)
    public void isCorrectDateFormatTestInvalidDay() throws BusinessException{
        Input.isCorrectDateFormat("39.12.2000");
    }

    @Test(expected = BusinessException.class)
    public void isCorrectDateFormatTestInvalidYear() throws BusinessException{
        Input.isCorrectDateFormat("12.12.20000");
    }

    @Test
    public void isCorrectTestDateFormat(){
        try {
            Assert.assertEquals(true, Input.isCorrectDateFormat("12.12.2000"));
        } catch (BusinessException e){
            Assert.fail();
        }
    }

    @Test
    public void isCorrectTestDateFormatNull(){
        try {
            Assert.assertEquals(true, Input.isCorrectDateFormat(null));
        } catch (BusinessException e){
            Assert.fail();
        }
    }

    @Test(expected = BusinessException.class)
    public void isYearTestTooLarge() throws BusinessException{
        Input.isYear("20000");
    }

    @Test(expected = BusinessException.class)
    public void isYearTestTooSmall() throws BusinessException{
        Input.isYear("200");
    }

    @Test
    public void isYearTestValid() {
        try {
            Assert.assertEquals(true, Input.isYear("2000"));
        } catch (BusinessException e){
            Assert.fail();
        }
    }

    @Test
    public void isYearTestNull() {
        try {
            Assert.assertEquals(true, Input.isYear(null));
        } catch (BusinessException e){
            Assert.fail();
        }
    }

    @Test(expected = BusinessException.class)
    public void isYearTestNotInt() throws BusinessException{
        Input.isYear("wqr");
    }

    @Test
    public void isAFuelTest() {
        try {
            Assert.assertEquals(true, Input.isAFuel("petrol"));
        } catch (BusinessException e){
            Assert.fail();
        }
    }

    @Test(expected = BusinessException.class)
    public void isAFuelTestInvalidFuel() throws BusinessException{
        Input.isAFuel("notafuel");
    }

    @Test
    public void isAFuelTestNull() {
        try {
            Assert.assertEquals(true, Input.isAFuel(null));
        } catch (BusinessException e){
            Assert.fail();
        }
    }

    @Test(expected = BusinessException.class)
    public void isValidPlateTestInvalidPlate() throws BusinessException{
        Input.isValidPlate("ABCDEFG12");
    }

    @Test
    public void isValidPlateTestValid() {
        try {
            Assert.assertEquals(true, Input.isValidPlate("ABC123"));
        } catch (BusinessException e){
            Assert.fail();
        }
    }

    @Test(expected = BusinessException.class)
    public void isValidVinTestTooSmall() throws BusinessException{
        Input.isValidVin("1234567890");
    }

    @Test
    public void isValidVinTestValid() {
        try {
            Assert.assertEquals(true, Input.isValidVin("12345678901234567"));
        } catch (BusinessException e){
            Assert.fail();
        }
    }

    @Test
    public void isValidVinTestNull() {
        try {
            Assert.assertEquals(true, Input.isValidVin(null));
        } catch (BusinessException e){
            Assert.fail();
        }
    }
}
