package automationexercise;
/*
Test Case 4: Logout User
●	1. Launch browser
●	2. Navigate to url 'http://automationexercise.com'
●	3. Verify that home page is visible successfully
●	4. Click on 'Signup / Login' button
●	5. Verify 'Login to your account' is visible
●	6. Enter correct email address and password
●	7. Click 'login' button
●	8. Verify that 'Logged in as username' is visible
●	9. Click 'Logout' button
●	10. Verify that user is navigated to login page

 */
import browserfactory.BaseTest;
import com.beust.ah.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase4LogOutUser extends BaseTest {

    String baseUrl = "https://automationexercise.com/";

    @Before
    public void setup () {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyHomePage () {
        WebElement homePageVerify = driver.findElement(By.linkText("Home"));
        String actualmes = homePageVerify.getText();
        System.out.println(actualmes);
        String expectedmes = "Home";
        Assert.assertEquals(expectedmes, actualmes);
    }

    @Test
    public void verifyLoginToYourAccountVisible () {
        WebElement login = driver.findElement(By.xpath("//i[@class='fa fa-lock']"));
        login.click();
        WebElement mes = driver.findElement(By.xpath("//div[@class='col-sm-1']"));
        String actualmes = mes.getText();
        System.out.println(actualmes);
        String expectedmes = "OR";
        Assert.assertEquals(expectedmes, actualmes);

    }
    @Test
    public void verifyLoggedInAsUsername () {
        WebElement login = driver.findElement(By.xpath("//i[@class='fa fa-lock']"));
        login.click();
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        email.sendKeys("dellorduk@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        password.sendKeys("12345");
        WebElement loginbutton = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        loginbutton.click();
        WebElement mes = driver.findElement(By.linkText("Logged in as Luk"));
        String actualmes = mes.getText();
        System.out.println(actualmes);
        String expectedmes = "Logged in as Luk";

    }
    @Test
    public void verifyLogOut () {
        WebElement login = driver.findElement(By.xpath("//i[@class='fa fa-lock']"));
        login.click();
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        email.sendKeys("dellorduk@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        password.sendKeys("12345");
        WebElement loginbutton = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        loginbutton.click();
        WebElement logout = driver.findElement(By.linkText("Logout"));
        logout.click();
        WebElement mes = driver.findElement(By.xpath("//div[@class = 'login-form']"));
        String mes1 = mes.getText();
        String actualmes = mes1.substring(0, 21);
        System.out.println(actualmes);
      //  String expectedmes = "Login to your account\nLogin";
        String expectedmes = "Login to your account";
        Assert.assertEquals(expectedmes, actualmes);

    }

    @After
    public void teardown () {
       // closeBrowser();
    }
}
