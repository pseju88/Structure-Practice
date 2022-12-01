//A package in Java is used to group related classes.
package org.example;
//importing a package of selenium.By
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
//Assertions in TestNG is Use to verify that the expected result and the actual result matched or not.
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import javax.swing.*;
import java.util.List;

// extends keyword is used to Inherit  HomePage from Utils.
public class Homepage extends Utils
{
    private By _voteButton = By.id("vote-poll-1");
    private By _currency = By.id("customerCurrency");
    private By _searchStore = By.id("small-searchterms");
    private By _searchBar = By.xpath("//button[@class=\"button-1 search-box-button\"]");
    String prtMsg = "Only Register User can Vote.";
    public void verifyRegistrationButtonIsonHomePage(){
        //Asserts that two objects are equal
        Assert.assertEquals(getTextFromElement(By.className("ico-register")),"Register","You are on Registration Page");

    }
    public void navigateToElectronicIsonHomePage()
    {
        ClickonElement(By.linkText("Electronics"));
    }
//    public void verifyToCurrencyButtonOnHomepage()
//    {
//        selectFromDropdownByVisibleText(_currency,"Euro");
//        selectFromDropdownByVisibleText(_currency,"US Dollar");
public void verifyCorrectCurrencySButtonDisplayIsUSD()
{

    selectFromDropdownByVisibleText(_currency,"US Dollar");
    List<WebElement> currency =  driver.findElements(By.className("prices"));
    for (WebElement element : currency)
    {
        Assert.assertTrue(element.getText().contains("$"));

        System.out.println(element.getText());
    }
}
    public void verifyCorrectCurrencyButtonDisplayIsEuro()
    {

        selectFromDropdownByVisibleText(_currency,"Euro");
        List<WebElement> currency =  driver.findElements(By.className("prices"));
        for (WebElement element : currency)
        {
            Assert.assertTrue(element.getText().contains("€"));
            System.out.println(element.getText());
        }


    }
    public void verifyToVoteButtonOnHomepage(){
        ClickonElement(_voteButton);
        driver.switchTo().alert().accept();
        // assert. equal() method tests if two values are equal or not
        Assert.assertEquals(prtMsg,"User must Registered to Vote");


    }
    public void hoverOverAndNavigateToDesiredCategoryPage(String category, String subCategory){
        WebElement categoryLink = driver.findElement((By.xpath("//ul[contains(@class,'notmobile')]//a[contains(.,'"+category+"')]")));
        String beforeHover = categoryLink.getCssValue("color");
        System.out.println("Before hover color for category link = " +beforeHover);

        Actions builder = new Actions(driver);
        Action mouseOverCategory = (Action) builder.moveToElement(categoryLink).build();
        mouseOverCategory.perform();

        String afterHover = categoryLink.getCssValue("color");
        System.out.println("After hover color for category link = " +afterHover);

        ClickonElement(By.linkText(subCategory));

    }
//public void clickOnRegistration(){ cli
       // WebElement cata
//}
public void searchSStore(){
    EnterText(_searchStore,"nike");
    ClickonElement(_searchBar);
}

}
