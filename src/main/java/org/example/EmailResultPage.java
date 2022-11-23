//A package in Java is used to group related classes.
package org.example;
//importing a package of selenium
import org.openqa.selenium.By;
//importing a package of testng.Assert
import org.testng.Assert;
// extends keyword is used to Inherit EmailResult from Utils.
public class  EmailResultPage extends Utils
{
    //Local variable regMsg1 introduced
    String regMess1 = "Your message has been sent.";

    public void verifyEmailMessageIsSentSuccessfully(){
        //These methods check that the URL is an expected one. With the timeout parameter that needs to be provided to the method
        waitForUrlToBe("https://demo.nopcommerce.com/productemailafriend/4",10);
        //local variable regMsg1 Declared to store the value get from reusable method GettextFromElement through Xpath,Id or by Class
        String regMsg1 = getTextFromElement(By.xpath("//div[@class=\"result\"]"));
        //Asserts that two objects are equal
        Assert.assertEquals(regMsg1,regMess1,"Your message has been sent.");
    }
}
