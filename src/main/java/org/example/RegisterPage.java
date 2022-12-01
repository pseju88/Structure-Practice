//A package in Java is used to group related classes.
package org.example;
//importing a package of selenium
import org.openqa.selenium.By;
//importing a package of testng Assert
import org.testng.Assert;

import static org.example.BasePage.driver;
// extends keyword is used to Inherit  RegisterPage from Utils.

public class RegisterPage extends Utils
{
 String regMsg = "register";
// Private Global Variable Declared to store the locator (By Id ,Class name,Xpath use for class only.)
   private By _IconRegister =By.className("ico-register");
    private By _genderField = By.id("gender-female");
    private By _firstNameField = By.id("FirstName");
    private By _lastnameField = By.id("LastName");
    private By _DateOfBirthDateField = By.xpath("//div[@class=\"date-picker-wrapper\"]/select[1]");
    private By _DateOfBirthMonthsField = By.xpath("//div[@class=\"date-picker-wrapper\"]/select[2]");
    private By _DateOfBirthYear = By.xpath("//div[@class=\"date-picker-wrapper\"]/select[3]");
    private By _emailField = By.id("Email");
    private By _CompanyField = By.id("Company");
    private By _NewsLetterField = By.id("Newsletter");
    private By _PasswordField = By.id("Password");
    private By _ConfirmPassword = By.id("ConfirmPassword");
    private By _registrationSubmitButtonField = By.id("register-button");
   private By _Continue = By.xpath("//a[@class=\"button-1 register-continue-button\"]");
    // VerifyUserIsOnRegisterPage Test Case for Register Page.
    public void VerifyUserIsOnRegistrationPage(){
        // assert false() methods checks whether the expected value is false or not.
     Assert.assertEquals(regMsg,"register","Your registration completed");

    }


    public void enterRegistrationOnDetails()
    {

       ClickonElement(_IconRegister);
        ClickonElement(_genderField);
        EnterText(_firstNameField,LoadPop.getProperty("FirstName"));
        EnterText(_lastnameField,"Patel");

        selectFromDropdownByVisibleText(_DateOfBirthDateField,"8");
        selectFromDropdownByVisibleText(_DateOfBirthMonthsField,"September");
        selectFromDropdownByVisibleText(_DateOfBirthYear,"1988");
        EnterText(_emailField,"seju_patel81"+getTimeStamp()+"@yahoo.com");
        EnterText(_CompanyField,"SAP Consultancy");
        ClickonElement(_NewsLetterField);
        EnterText(_PasswordField,"Test123");
        EnterText(_ConfirmPassword,"Test123");
        WaitForElementToBeClickable(_registrationSubmitButtonField,30);
        ClickonElement(_registrationSubmitButtonField);
        ClickonElement(_Continue);


    }
}
