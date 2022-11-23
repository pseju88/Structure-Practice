//A package in Java is used to group related classes.
package org.example;
//importing a package of selenium
import org.openqa.selenium.By;
//importing a package of selenium.WebElements
import org.openqa.selenium.WebElement;
// importing a package of java util list
import java.util.List;
//extends keyword Is used to Inherit child class(NewsDetails) from parent class(Utils).
public class NewsDetails extends Utils {
    // Private Global Variable Declared to store the locator (By Id ,Class name,Xpath use for class only.)
    private By _NewsDetails = By.xpath("//div[@class=\"news-items\"]/div/div[3]//a[@href=\"/nopcommerce-new-release\"]");
    private By _Tittle = By.id("AddNewComment_CommentTitle");
    private By _Comment = By.id("AddNewComment_CommentText");
    private By _newCommentButton = By.xpath("//button[@class=\"button-1 news-item-add-comment-button\"]");

    public void verifyToDetailOnNewsComment() {
        //ClickOnElement,EnterText[Reusable method called] for uniquely identify a web element with in the webpage by Id, By Classname, By Xpath
        ClickonElement(_NewsDetails);
        EnterText(_Tittle, "Good Product");
        EnterText(_Comment, "good services");
        ClickonElement(_newCommentButton);
        List<WebElement> commentList = driver.findElements(By.xpath("//div[@class=\"comments\"]"));
        for (WebElement element : commentList) {
            System.out.println(element.getText());
        }
    }
}