package automationexercise;
/*Test Case 3: Login User with incorrect email and password
●	1. Launch browser
●	2. Navigate to url 'http://automationexercise.com'
●	3. Verify that home page is visible successfully
●	4. Click on 'Signup / Login' button
●	5. Verify 'Login to your account' is visible
●	6. Enter incorrect email address and password
●	7. Click 'login' button
●	8. Verify error 'Your email or password is incorrect!' is visible


 */
import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase3LoginUserWithIncorrectEmailAndPassword extends BaseTest {

    String baseUrl = "https://automationexercise.com/";

    @Before
    public void setup (){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyHomepage (){
        String actualmes = driver.findElement(By.linkText("Home")).getText();
        System.out.println(actualmes);
        String expectedmes = "Home";
        Assert.assertEquals(expectedmes, actualmes);
    }

    @Test
    public void verifyLoginToYourAccountVisible (){
        WebElement login = driver.findElement(By.xpath("//i[@class='fa fa-lock']"));
        login.click();
        WebElement mes = driver.findElement(By.xpath("//div[@class='col-sm-1']"));
        String actualmes = mes.getText();
        System.out.println(actualmes);
        String expectedmes = "OR";
        Assert.assertEquals(expectedmes,actualmes);
    }
    @Test
    public void verifyError (){
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("lord@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("12345");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        String actualmes = driver.findElement(By.xpath("//p[@style='color: red;']")).getText();
      //  driver.findElement(By.xpath("//p[@style='color: red;']"));
        System.out.println(actualmes);
        String expectedmes = "Your email or password is incorrect!";
        Assert.assertEquals(expectedmes, actualmes);

    }


    @After
    public void teardown (){
       // closeBrowser();
    }
}
