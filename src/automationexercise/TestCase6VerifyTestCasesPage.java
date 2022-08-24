package automationexercise;
/*
Test Case 6: Verify Test Cases Page
●	1. Launch browser
●	2. Navigate to url 'http://automationexercise.com'
●	3. Verify that home page is visible successfully
●	4. Click on 'Test Cases' button
●	5. Verify user is navigated to test cases page successfully

 */
import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase6VerifyTestCasesPage extends BaseTest {

    String baseUrl = "https://automationexercise.com/";

    @Before
    public void setup (){
        openBrowser(baseUrl);
    }

    @Test
    public void verifyHomePage () {
        WebElement home = driver.findElement(By.linkText("Home"));
        String actualmes = home.getText();
        String expectedmes = "Home";
        System.out.println(actualmes);
        System.out.println("=================");
        Assert.assertEquals(expectedmes,actualmes);
    }

    @Test
    public void verifyUserNavigatedToTestCasesPageSuccessfully (){
        verifyHomePage();
        WebElement testcases = driver.findElement(By.linkText("Test Cases"));
        testcases.click();
        WebElement mes = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        String actualmes = mes.getText();
        System.out.println(actualmes);
        String expectedmes = "TEST CASES";
        Assert.assertEquals(expectedmes,actualmes);


    }


    @After
    public void teardown () {
//        closeBrowser();
    }

}
