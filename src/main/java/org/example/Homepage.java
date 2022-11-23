//A package in Java is used to group related classes.
package org.example;
//importing a package of selenium
import org.openqa.selenium.By;
//importing a package of testng.Assert
import org.testng.Assert;
// extends keyword is used to Inherit  HomePage from Utils.
public class Homepage extends Utils
{
    private By _voteButton = By.id("vote-poll-1");
    private By _currency = By.id("customerCurrency");
    String prtMsg = "Only Register User can Vote.";
    public void verifyRegistrationButtonIsonHomePage(){
        //Asserts that two objects are equal
        Assert.assertEquals(getTextFromElement(By.className("ico-register")),"Register","You are on Registration Page");

    }
    public void navigateToElectronicIsonHomePage()
    {
        ClickonElement(By.linkText("Electronics"));
    }
    public void verifyToCurrencyButtonOnHomepage()
    {
        selectFromDropdownByVisibleText(_currency,"Euro");
        selectFromDropdownByVisibleText(_currency,"US Dollar");


    }
    public void verifyToVoteButtonOnHomepage(){
        ClickonElement(_voteButton);
        driver.switchTo().alert().accept();
        // assert. equal() method tests if two values are equal or not
        Assert.assertEquals(prtMsg,"User must Registered to Vote");


    }



}
