package testsuit;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    @Before
    public void setUp() {
        setBaseUrl();
    }

    @Test
    public void serSholdLoginSuccessfullyWithValidCredentials() {
        //Enter “tomsmith” username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //Enter “SuperSecretPassword!” password
        // Click on ‘LOGIN’ button
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@class = 'radius']")).click();
        //Verify the text “Secure Area"
        WebElement loginHeader = driver.findElement(By.xpath("//h2[text() = ' Secure Area']"));
        String headerText = loginHeader.getText();
        Assert.assertEquals("The Secure Area text is not as expected", "Secure Area", headerText);

    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        //Enter tomsmith1 username

        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        //Enter “SuperSecretPassword!” password
        // Click on ‘LOGIN’ button
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@class = 'radius']")).click();
        //Verify the error message “Your username is invalid!"
        String expectedText = "Your username is invalid!";
        WebElement logInHeaderPageTextElement = driver.findElement(By.xpath("//div[@class='flash error']"));
        String actualText = logInHeaderPageTextElement.getText().substring(0,25);
        Assert.assertEquals("Not redirected to expected page",expectedText,actualText);
        Assert.assertEquals(expectedText,actualText);

    }
    @Test
    public void verifyThePasswordErrorMessage(){
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //Enter “SuperSecretPassword!” password
        // Click on ‘LOGIN’ button
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath("//button[@class = 'radius']")).click();
        //Verify the error message “Your password is invalid!”

        String expectedText = "Your password is invalid!";
        WebElement logInHeaderPageTextElement = driver.findElement(By.xpath("//div[@class='flash error']"));
        String actualText = logInHeaderPageTextElement.getText().substring(0,25);
        Assert.assertEquals("Not redirected to expected page",expectedText,actualText);
        Assert.assertEquals(expectedText,actualText);

    }
    @After
    public void tearDown() {

        driver.close();
    }
}

