package automationexercise;
/*
Test Case 8: Verify All Products and product detail page
●	1. Launch browser
●	2. Navigate to url 'http://automationexercise.com'
●	3. Verify that home page is visible successfully
●	4. Click on 'Products' button
●	5. Verify user is navigated to ALL PRODUCTS page successfully
●	6. The products list is visible
●	7. Click on 'View Product' of first product
●	8. User is landed to product detail page
●	9. Verify that detail detail is visible: product name, category, price, availability, condition, brand

 */
import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestCase8VerifyAllProductAndProductDetailPage extends BaseTest {

    String baseUrl = "https://automationexercise.com/";

    @Before
    public void setup () {
        openBrowser(baseUrl);
    }
    @Test

    public void verifyHomePage (){
        String actualmes = driver.findElement(By.linkText("Home")).getText();
        System.out.println(actualmes);
        System.out.println("==========");
        String expectedmes = "Home";
        Assert.assertEquals(expectedmes,actualmes);
    }
    @Test
    public void verifyUserNavigatedToAllProducts (){
        verifyHomePage();
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        String actualmes = driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();
        System.out.println(actualmes);
        System.out.println("+++++++++++++");
        String expectedmes = "ALL PRODUCTS";
        Assert.assertEquals(expectedmes, actualmes);
    }

    @Test
    public void productListIsVisible () {
        verifyUserNavigatedToAllProducts();
        WebElement productlist = driver.findElement(By.xpath("//div[@class='features_items']"));
        String mes = productlist.getText();
    }
    @Test
    public void verifyTheDetails () {
        verifyUserNavigatedToAllProducts();
//        WebElement fproduct = driver.findElement(By.xpath("//a[@href='/product_details/1']"));
//        fproduct.click();
      //    driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();
    //    String productname = driver.findElement(By.xpath("//div[@class= 'product-information']")).getText();
    //    System.out.println(productname);

    }
    @Test
    public void verifyDetailsVisible (){
        driver.get("https://automationexercise.com/product_details/1");
        String actualmes = driver.findElement(By.xpath("//div[@class='product-information']")).getText();
        System.out.println(actualmes);
//        String expectedmes = "Blue Top\n" +
//                "Category: Women > Tops\n" +
//                "Rs. 500\n" +
//                "Quantity: Add to cart\n" +
//                "Availability: In Stock\n" +
//                "Condition: New\n" +
//                "Brand: Polo";
        String expectedmes = "Blue Top\nCategory: Women > Tops\nRs. 500\nQuantity: Add to cart\nAvailability: In Stock\nCondition: New\nBrand: Polo";
        Assert.assertEquals(expectedmes, actualmes);
    }




    @After
    public void teardown () {
//        closeBrowser();
    }

}
