//A package in Java is used to group related classes.
package org.example;
//importing a package of selenium
import org.openqa.selenium.By;
//importing a package of testng.Assert
import org.testng.Assert;
// extends keyword is used to Inherit  HomePage from Utils.
public class Homepage extends Utils
{
    public void verifyRegistrationButtonIsonHomePage(){
        //Asserts that two objects are equal
        Assert.assertEquals(getTextFromElement(By.className("ico-register")),"Register");

    }
}
