//A package in Java is used to group related classes.
package org.example;
// //importing a package of selenium chromedriver.
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

// extends keyword is used to Inherit  DriverManager from Utils.
public class DriverManager extends Utils
{
    String browserName = LoadPop.getProperty("browser");
    public static final String USERNAME = LoadPop.getProperty("BROWSERSTACK_USERNAME");
    public static final String AUTOMATE_KEY = LoadPop.getProperty("BROWSERSTACK_ACCESS_KEY");
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    //String browserName = LoadPop.getProperty("browser");

    //    String browserName = System.getProperty("browser");
    boolean runIncloud = Boolean.parseBoolean(LoadPop.getProperty("cloud"));
    MutableCapabilities capabilities = new MutableCapabilities();


    //String browserName = "Firefox";

    public void openBrowser(){

        //run in cloud==============
        if(runIncloud){
            System.out.println("RUNNING IN CLOUDE");
            //connect to cloud
            if (browserName.equalsIgnoreCase("Edge")) {
                ///connect with browserstack
                capabilities.setCapability("browserName", "Edge");
                capabilities.setCapability("browserVersion", "106.0");
                HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
                browserstackOptions.put("os", "Windows");
                browserstackOptions.put("osVersion", "10");
                browserstackOptions.put("local", "false");
                browserstackOptions.put("seleniumVersion", "4.1.0");
                capabilities.setCapability("bstack:options", browserstackOptions);

            } else if (browserName.equalsIgnoreCase("Firefox"))
            {
                ///connect with browserstack
                capabilities.setCapability("browserName", "firefox");
                capabilities.setCapability("browserVersion", "106.0");
                HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
                browserstackOptions.put("os", "Windows");
                browserstackOptions.put("osVersion", "11");
                browserstackOptions.put("local", "false");
                browserstackOptions.put("seleniumVersion", "4.1.0");
                capabilities.setCapability("bstack:options", browserstackOptions);
            }else if (browserName.equalsIgnoreCase("Chrome"))
            {
                ///connect with browserstack
                capabilities.setCapability("browserName", "Chrome");
                capabilities.setCapability("browserVersion", "107.0");
                HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
                browserstackOptions.put("os", "Windows");
                browserstackOptions.put("osVersion", "11");
                browserstackOptions.put("local", "false");
                browserstackOptions.put("seleniumVersion", "4.1.0");

                capabilities.setCapability("bstack:options", browserstackOptions);
            } else {
                System.out.println("Your browser name is wrong or missing implementation:" + browserName);
            }
            try {
                driver = new RemoteWebDriver(new URL(URL), capabilities);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            System.out.println("Running locally");
            //run is locally
            if (browserName.equalsIgnoreCase("Chrome")) {

                System.setProperty("webdriver.chrome.driver", "src/test/Drivers2/chromedriver.exe");
                driver = new ChromeDriver();
            }
            else if (browserName.equalsIgnoreCase("Firefox")){
                System.setProperty("webdriver.gecko.driver", "src/test/Drivers2/geckodriver.exe");
                driver = new FirefoxDriver();

            }else if (browserName.equalsIgnoreCase("Edge")){
                System.setProperty("webdriver.edge.driver", "src/test/Drivers2/msedgedriver.exe");
                driver = new EdgeDriver();
            }
            else{
                System.out.println("Your browser name is wrong or missing:\" +browserName");
            }
        }

    //String  browserName = "chrome";
    //public void openBrowser(){


//        //Set the path of the driver for the chromeBrowser
//       // System.setProperty("webdriver.chrome.driver", "src/test/Drivers2/chromedriver.exe");
//        //creating object with chromeBrowser
//        //driver = new ChromeDriver();
//        System.setProperty("webdriver.edge.driver", "src/test/Drivers2/msedgedriver.exe");
//        //creating object with chromeBrowser
//        driver = new EdgeDriver();
//        //System.setProperty("webdriver.gecko.driver", "src/test/Drivers2/msedgedriver.exe");
//        //creating object with chromeBrowser
//        //driver = new FirefoxDriver();
    // To maximize the browser
    driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //.get() method is used to open URL and it will wait till the whole page gets loaded
    driver.get(LoadPop.getProperty("url"));
    //  driver.get("http://omayo.blogspot.com/");
}
public void CloseBrowser(){
        driver.quit();
}

}
