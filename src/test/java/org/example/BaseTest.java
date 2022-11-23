//A package in Java is used to group related classes.
package org.example;
//importing a package of AfterMethod
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
//importing a package of BeforeMethod
import org.testng.annotations.BeforeMethod;
// extends keyword is used to Inherit  BasePage from Utils.
public class BaseTest extends Utils {
    DriverManager driverManager = new DriverManager();

    //Executes before each test method
    @BeforeMethod
    public void setUp() {
        driverManager.openBrowser();
    }

    //Executes after each test method
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            captureScreenshot(result.getName());

        }

            driver.close();

    }
}