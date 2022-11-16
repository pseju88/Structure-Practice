//A package in Java is used to group related classes.
package org.example;
//importing a package of selenium

import org.openqa.selenium.By;
//importing a testng.Assert
import org.testng.Assert;
// extends keyword is used to Inherit  RegisterResult from Utils.
public class RegisterResult extends Utils
{
    String regMsgg  = "Your registration completed";
    public void VerifyUserHasBeenRegsiteredSuccessfully(){
        waitForUrlToBe("https://demo.nopcommerce.com/registerresult/1?returnUrl=/",20);
   String regMsg = getTextFromElement(By.className("result"));
        //System.out.println(regMsg);
        //Asserts that two objects are equal
    Assert.assertEquals(regMsg,regMsgg,"Your registration completed");
    }
}
