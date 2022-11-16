//A package in Java is used to group related classes.
package org.example;
//importing a package of Test
import org.testng.annotations.Test;
// extends keyword is used to Inherit  TestSuit Page from BaseTest.
public class TestSuit extends BaseTest
{
    //Creating object of Homepage
    Homepage homepage = new Homepage();
    //Creating object of RegisterPage
    RegisterPage registerPage = new RegisterPage();
    //Creating object of RegisterResult

    //registerPage.clickRegistration();
    RegisterResult registerResult = new RegisterResult();

    @Test
    public void register() {
        //click on register button
        homepage.verifyRegistrationButtonIsonHomePage();
        //Verify user is on register page
        registerPage.VerifyUserIsOnRegistrationPage();
        //enter registration details
        registerPage.enterRegistrationOnDetails();
        //verify user register successfully
        registerResult.VerifyUserHasBeenRegsiteredSuccessfully();


    }
}
