package automationexercise;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase9SearchProduct extends BaseTest {

    String baseUrl = "https://automationexercise.com/";

    @Before
    public void setup (){
        openBrowser(baseUrl);
    }

    @Test
    /*
    ●	1. Launch browser
●	2. Navigate to url 'http://automationexercise.com'
●	3. Verify that home page is visible successfully

     */

    public void verifyHomePage () {
        String actualmes = driver.findElement(By.linkText("Home")).getText();
        System.out.println(actualmes);
        String expectedmes = "Home";
        Assert.assertEquals(expectedmes,actualmes);
    }
    @Test
    /*
    ●	4. Click on 'Products' button
●	5. Verify user is navigated to ALL PRODUCTS page successfully

     */
    public void verifyUserNavigatedToAllProducts () {
        verifyHomePage();
        System.out.println("===============");
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        String actualmes = driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();
        System.out.println(actualmes);
        String expectedmes = "ALL PRODUCTS";
        Assert.assertEquals(expectedmes,actualmes);

    }
    @Test
    /*
    ●	6. Enter product name in search input and click search button
●	7. Verify 'SEARCHED PRODUCTS' is visible
     */
    public void verifySearchedProducts () {
        verifyUserNavigatedToAllProducts();
        WebElement search = driver.findElement(By.xpath("//input[@id='search_product']"));
        search.sendKeys("men Tshirt");
        WebElement searchbutton = driver.findElement(By.xpath("//button[@id='submit_search']"));
        searchbutton.click();
        WebElement mes = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        String actualmes = mes.getText();
        System.out.println("+++++++++++++++++++++");
        System.out.println(actualmes);
        System.out.println("!!!!!!!!!!!!!!!!!!!!");
        String expectedmes = "SEARCHED PRODUCTS";
        Assert.assertEquals(expectedmes, actualmes);
    }
    @Test
    /*8. Verify all the products related to search are visible
     */
    public void verifyAllProductsVisible (){
        verifySearchedProducts();
        WebElement mes = driver.findElement(By.xpath("//div[@class='productinfo text-center']/p"));
        String actualmes = mes.getText();
        System.out.println(actualmes);
        String expectedmes = "Men Tshirt";
        Assert.assertEquals(expectedmes, actualmes);
    }




    @After
    public void teardown () {
        //closeBrowser();
    }
}
