/*3. Write down the following test into ‘LoginTest’ class
1. userSholdLoginSuccessfullyWithValidCredentials
* Enter “tomsmith” username
* Enter “SuperSecretPassword!” password
* Click on ‘LOGIN’ button
* Verify the text “Secure Area”
2. verifyTheUsernameErrorMessage
* Enter “tomsmith1” username
* Enter “SuperSecretPassword!” password
* Click on ‘LOGIN’ button
* Verify the error message “Your username
 is invalid!”
3. verifyThePasswordErrorMessage
* Enter “tomsmith” username
* Enter “SuperSecretPassword” password
* Click on ‘LOGIN’ button
* Verify the error message “Your password
 is invalid!”*/
package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String BaseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(BaseUrl);
    }
    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {

        sendTextToElement(By.id("username"),"tomsmith"); //Find username and enter the username
        sendTextToElement(By.id("password"),"SuperSecretPassword!"); //Find password and enter the password
        clickOnElement(By.xpath("//i[contains(text(),'Login')]"));//Find Login Button and Click on Login Button

        String ActMsg = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/h2[1]"));//Find the Secure Area text element and get the text
        System.out.println("Actual Message:"+ActMsg);
        messageValidation( "Secure Area",ActMsg);//Validate actual and expected message
    }
    @Test
    public void verifyTheUsernameErrorMessage() {

        sendTextToElement(By.id("username"),"tomsmith1");//Find username and enter the username
        sendTextToElement(By.id("password"),"SuperSecretPassword!");//Find password and enter the password
        clickOnElement(By.xpath("//i[contains(text(),'Login')]"));//Find Login Button and Click on Login Button

        String ActMsg = getTextFromElement(By.xpath("//div[@id='flash']")); //Find the Your username is invalid! text element and get the text
        System.out.println("Actual Message:"+ActMsg);
        messageValidation("Your username is invalid!\n"+ "×",ActMsg);
    }
    @Test
    public void verifyThePasswordErrorMessage() {
        sendTextToElement(By.id("username"),"tomsmith");//Find username and enter the username
        sendTextToElement(By.id("password"),"SuperSecretPassword");//Find password and enter the password
        clickOnElement(By.xpath("//i[contains(text(),'Login')]"));//Find Login Button and Click on Login Button

        String ActMsg = getTextFromElement(By.id("flash"));//Find the Secure Area text element and get the text
        System.out.println("Actual Message:"+ActMsg);
        messageValidation( "Your password is invalid!\n"+ "×",ActMsg);//Validate actual and expected message
    }
    @After
    public void closedown(){
        closeBrowser();
    }
}

