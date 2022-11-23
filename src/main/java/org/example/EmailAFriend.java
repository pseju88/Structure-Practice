//A package in Java is used to group related classes.
package org.example;
//importing a package of selenium WbDriver
import org.openqa.selenium.By;

// extends keyword is used to Inherit EmailAFriend from Utils.
public class EmailAFriend extends Utils
{
    // Private Global Variable Declared to store the locator (By Id ,Class name,Xpath use for class only.)
    private By _appleMacbookPro = By.xpath("//h2[@class=\"product-title\"]//a[@href=\"/apple-macbook-pro-13-inch\"]");
    private By _EmilAFriend = By.xpath("//div[@class=\"email-a-friend\"]");
    private By _freiendsEmail = By.id("FriendEmail");
    private By _personalMessage = By.id("PersonalMessage");
    private By _sendEmail = By.className("buttons");

    public void enterEmailDetails ()
    {
        //ClickOnElement,EnterText[Reusable method called] for uniquely identify a web element with in the webpage by Id, By Classname, By Xpath

        ClickonElement(_appleMacbookPro);
        ClickonElement(_EmilAFriend);
        EnterText(_freiendsEmail, "sp88" + getTimeStamp() + "@gmail.com");
        EnterText(_personalMessage, "It's fantastic item");
        ClickonElement(_sendEmail);
    }
}
