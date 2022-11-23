//A package in Java is used to group related classes.
package org.example;
//importing a package of selenium
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
//importing a package of selenium WebDriver.
//importing a package of selenium WebElement.
//importing a package of selenium .ui.ExpectedConditions.
import org.openqa.selenium.support.ui.ExpectedConditions;
//importing a package of selenium.ui.Select.
import org.openqa.selenium.support.ui.Select;
//importing a package of selenium.ui.WebDriverWait.
import org.openqa.selenium.support.ui.WebDriverWait;
//importing a package of Java.nio.ByteBuffer
//importing a package of Java.text.SimpleDateFormat.
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
//importing a package of Java.time.Duration.
import java.time.Duration;


public class Utils extends BasePage {
    // creating method and returns timeStamp value corresponding to the given string
    public static String getTimeStamp() {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        return timeStamp;
    }

    //enables WbDriver to check if one or more web elements are visible
    public static void waitForElementToBeVisible(By by, int duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //enables WbDriver to check if one or more web elements are Clickable
    public static void WaitForElementToBeClickable(By by, int duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.elementToBeClickable(by));

    }

    //These methods check that the URL is an expected one. With the timeout parameter that needs to be provided to the method
    public static void waitForUrlToBe(String url, int duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    // creating dropdown method to select value from list
    public static void selectFromDropdownByVisibleText(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    // creating dropdown method to select value from list
    public static void selectFromDropDownByValue(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(text);
    }

    // creating dropdown method to select value from list
    public static void selectFromDropDownByIndex(By by, int num) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(num);
    }

    // method simulates a mouse-click on an element
    public void ClickonElement(By by) {
        driver.findElement(by).click();
    }

    //to input content in editable text fields or password fields in a webpage.
    //findElement command is used to uniquely identify a web element within the web page
    public void EnterText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    // verifying messages, errors, asserting WebElements, and many more.
    //findElement command is used to uniquely identify a web element within the web page
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }
public static void screenShotName(Method method){
        method.getName();
}
    public static void captureScreenshot(String screenShotName) {
//Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        //Call getScreenshotAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile = new File("src/ScreenShot/"+screenShotName+getTimeStamp()+".jpg");
        //Copy file at destination
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}