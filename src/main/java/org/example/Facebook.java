//A package in Java is used to group related classes.
package org.example;
//importing a package of selenium WbDriver
import org.openqa.selenium.By;
//importing a package of testng Assert
import org.testng.Assert;
// extends keyword is used to Inherit  FacebookPage from Utils.
public class Facebook extends Utils
{
    // Private Global Variable Declared to store the locator (ByXpath)

    private By _facebookLogo = By.xpath("//a[@href=\"http://www.facebook.com/nopCommerce\"]");

    String regMsg = "http://www.facebook.com/nopCommerce";

    public void verifyToFacebookButtonOnHomePage() {


        // Store the current window handle
        String MainWindowHandleBefore = driver.getWindowHandle();

// Perform the click operation that opens new window
        ClickonElement(_facebookLogo);
// Switch to new window opened
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
// Perform the actions on new window
        System.out.println(driver.getCurrentUrl());
// Close the new window, if that window no more required
        driver.close();
// Switch back to original browser (first window)
        driver.switchTo().window(MainWindowHandleBefore);
        Assert.assertEquals(regMsg,"http://www.facebook.com/nopCommerce","You are in not facebook page.");

        // System.out.println(driver.getCurrentUrl());
// Continue with original browser (first window)
    }
}
