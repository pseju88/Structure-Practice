//A package in Java is used to group related classes.
package org.example;
//importing a package of selenium
import org.openqa.selenium.By;
//importing a package of selenium WbDriver
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CameraPhotoPage extends Utils {
    public void GetProductTitles(){
        ClickonElement(By.linkText("Camera & photo"));
        List<WebElement> productNames = driver.findElements(By.xpath("//h2[@class='product-title']"));
        for(WebElement element:productNames){

            System.out.println(element.getText());
        }


    }
    public void cameraAndPhotoResult(){
        waitForUrlToBe("https://demo.nopcommerce.com/camera-photo",20);
    }
}
