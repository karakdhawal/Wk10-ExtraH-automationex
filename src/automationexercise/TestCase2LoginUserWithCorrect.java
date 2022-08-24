package automationexercise;
/*     Base url: 'http://automationexercise.com'
Test Case 2: Login User with correct email and password
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Delete Account' button
10. Verify that 'ACCOUNT DELETED!' is visible
 */
import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase2LoginUserWithCorrect extends BaseTest {
    String baseUrl = "https://automationexercise.com/";

    @Before
    public void setup (){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyHomePage (){
        //WebElement homePageVerify = driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        WebElement homePageVerify = driver.findElement(By.linkText("Home"));
        String actualmes = homePageVerify.getText();
        System.out.println(actualmes);
        String expectedmes = "Home";
        Assert.assertEquals(expectedmes,actualmes);
    }
    @Test
    public void verifyLoginToYourAccountVisible (){

        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();
       // String actualmes = driver.findElement(By.xpath("//div[@class='col-sm-1']")).getText();
        //String actualmes = driver.findElement(By.linkText("Login to your account")).getText(); - error

//        WebElement login = driver.findElement(By.xpath("//i[@class='fa fa-lock']"));
//        login.click();
//        WebElement mes = driver.findElement(By.xpath("//div[@class='col-sm-1']"));
//        String actualmes = mes.getText();

      //  System.out.println(actualmes);
      //  String expectedmes = "OR";
        WebElement mes = driver.findElement(By.xpath("//div[@class = 'login-form']"));
        String actualmes = mes.getText();
        System.out.println(actualmes);
        String expectedmes = "Login to your account\nLogin";
        Assert.assertEquals(expectedmes, actualmes);

    }
    @Test
    public void verifyLoggedInAsUsername () {
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("dellorduk@gmail.com");
//        WebElement email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
//        email.sendKeys("dellorduk@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("12345");
//        WebElement password = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
//        password.sendKeys("12345");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
//        WebElement login = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
//        login.click();
        String actualmes = driver.findElement(By.linkText("Logged in as Luk")).getText();
//        WebElement mes = driver.findElement(By.linkText("Logged in as Luk"));
//        String actualmes = mes.getText();

        System.out.println(actualmes);
        String expectedmes = "Logged in as Luk";
        Assert.assertEquals(expectedmes, actualmes);

    }
    @Test
    public void deleteAccount () {
        WebElement login = driver.findElement(By.xpath("//i[@class='fa fa-lock']"));
        login.click();
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        email.sendKeys("dellorduk@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        password.sendKeys("12345");
        WebElement login1 = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        login1.click();
        WebElement delete = driver.findElement(By.xpath("//i[@class='fa fa-trash-o']"));
        //delete.click();

    }

    @After
    public void teardown (){
       // closeBrowser();
    }


}
