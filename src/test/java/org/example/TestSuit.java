//A package in Java is used to group related classes.
package org.example;
//importing a package of Test
import org.testng.annotations.Test;
// extends keyword is used to Inherit  TestSuit Page from BaseTest.
public class TestSuit extends BaseTest
{
    //Creating object of Homepage
    Homepage homepage = new Homepage();
    //Creating object of RegisterPage
    RegisterPage registerPage = new RegisterPage();
    //Creating object of RegisterResult

    //registerPage.clickRegistration();
   RegisterResultPage registerResultPage = new RegisterResultPage();
//    ElectronicPage electronicPage = new ElectronicPage();
//    CameraPhotoPage cameraPhotoPage = new CameraPhotoPage();
    //Creating object of NewsDetails
    NewsDetails newsDetails = new NewsDetails();
    //Creating object of NewsResult
    NewsResult newsResult = new NewsResult();
    //Creating object of Facebook
    Facebook facebook = new Facebook();
    //Creating object of EmailAFriend
    EmailAFriend emailAFriend = new EmailAFriend();
    //Creating object of EmailResultPage
    EmailResultPage emailResultPage = new EmailResultPage();

//    @Test
//    public void verifyEachProductHasName(){
//        homepage.navigateToElectronicIsonHomePage();
//        electronicPage.ElectronicButtononIsonHomePage();
//        cameraPhotoPage.GetProductTitles();
//
//    }

    @Test
    public void register() {
        //click on register button
        homepage.verifyRegistrationButtonIsonHomePage();
        //Verify user is on register page
        registerPage.VerifyUserIsOnRegistrationPage();
        //enter registration details
        registerPage.enterRegistrationOnDetails();
        //verify user register successfully
       // registerResultPage.verifyUserHasBeenRegisteredSuccessfully();



    }
    @Test
    public void currencyButtonOnHomepage(){
        // Method of Homepage class called through object
        homepage.verifyToCurrencyButtonOnHomepage();
    }
    @Test
    public void VoteButtonOnHomepage(){
        // Method of Homepage class called through object
        homepage.verifyToVoteButtonOnHomepage();
    }
    @Test
    public void verifyToDetailOnNewsComment(){
        // Method of NewsDetail And NewsResult class called through object
        newsDetails.verifyToDetailOnNewsComment();
        newsResult.verifyMessageIsSentSuccessfully();
    }
    @Test
    public void verifyToFacebookButtonOnHomePage(){
        // Method of Facebook class called through object

        facebook.verifyToFacebookButtonOnHomePage();
    }
    @Test
    public void EmailAFriend(){
        //click on register button
        registerPage.VerifyUserIsOnRegistrationPage();
        //enter registration details
        registerPage.enterRegistrationOnDetails();
        //enter Email details
        emailAFriend.enterEmailDetails();
        //verify user enter emailmessage successfully
        emailResultPage.verifyEmailMessageIsSentSuccessfully();
    }


}
