package automationexercise;
/*
Test Case 5: Register User with existing email
●	1. Launch browser
●	2. Navigate to url 'http://automationexercise.com'
●	3. Verify that home page is visible successfully
●	4. Click on 'Signup / Login' button
●	5. Verify 'New User Signup!' is visible
●	6. Enter name and already registered email address
●	7. Click 'Signup' button
●	8. Verify error 'Email Address already exist!' is visible

 */
import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TestCase5RegisterUserWithExistingEmail extends BaseTest {

    String baseUrl = "https://automationexercise.com/";

    @Before
    public void setup (){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyHomePage (){
        String actualmes = driver.findElement(By.linkText("Home")).getText();
        System.out.println(actualmes);
        System.out.println("+++++++++++");
        String expectedmes = "Home";
        Assert.assertEquals(expectedmes, actualmes);
    }
    @Test
    public void verifyNewUserSignUpVisible (){
        verifyHomePage();
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();
        String actualmes = driver.findElement(By.xpath("//div[@class='signup-form']")).getText();
        System.out.println(actualmes);
        String expectedmes = "New User Signup!\nSignup";
        Assert.assertEquals(expectedmes, actualmes);
        System.out.println("=======================");
        String actualmes1 = actualmes.substring(0,16);
        System.out.println(actualmes1);
        String expectedmes1 = "New User Signup!";
        Assert.assertEquals(expectedmes1, actualmes1);

    }
    @Test
    public void verifyError (){
        verifyNewUserSignUpVisible();
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Lord");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("dellorduk@gmail.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        String actualmes = driver.findElement(By.xpath("//p[@style='color: red;']")).getText();
        System.out.println("-------------------");
        System.out.println(actualmes);
        String expectedmes = "Email Address already exist!";
        Assert.assertEquals(expectedmes,actualmes);
    }


    @After
    public void teardown (){

        //closeBrowser();
    }
}
