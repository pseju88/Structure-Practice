//A package in Java is used to group related classes.
package org.example;
// //importing a package of selenium chromedriver.
import org.openqa.selenium.chrome.ChromeDriver;
// extends keyword is used to Inherit  DriverManager from Utils.
public class DriverManager extends Utils
{
    public void openBrowser(){

        //Set the path of the driver for the chromeBrowser
        System.setProperty("webdriver.chrome.driver", "src/test/Drivers2/chromedriver.exe");
        //creating object with chromeBrowser
        driver = new ChromeDriver();
    // To maximize the browser
    driver.manage().window().maximize();
    //.get() method is used to open URL and it will wait till the whole page gets loaded
    driver.get("https://demo.nopcommerce.com/");
    //  driver.get("http://omayo.blogspot.com/");
}


}
