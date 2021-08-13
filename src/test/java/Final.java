import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.*;

public class Final {
    WebDriver driver;
    public Final() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:/Users/www.leptopi.ge/OneDrive/Desktop/chromedriver.exe"
        );
        driver = new ChromeDriver();
    }

    @Test
    public void test() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("http://tutorialsninja.com/demo/");
//    - Go to 'My Account' and click on 'Register' button
        driver.findElement(By.className("dropdown")).click();
        driver.findElement(linkText("Register")).click();
//    - Fill personal information, choose 'Subscribe' Yes and click on 'Continue' button
        String string = "rame1";
        String email = "email@emailA.ge";
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement inputFirstName = driver.findElement(By.id("input-firstname"));
        inputFirstName.click();
        inputFirstName.sendKeys(string);

        WebElement inputLastName = driver.findElement(By.id("input-lastname"));
        inputLastName.click();
        inputLastName.sendKeys(string);

        WebElement inputEmail = driver.findElement(By.id("input-email"));
        inputEmail.click();
        inputEmail.sendKeys(email);

        WebElement inputTelephone = driver.findElement(By.id("input-telephone"));
        inputTelephone.click();
        inputTelephone.sendKeys(string);

        WebElement inputPassword = driver.findElement(By.id("input-password"));
        inputPassword.click();
        inputPassword.sendKeys(string);

        WebElement inputConfirm = driver.findElement(By.id("input-confirm"));
        inputConfirm.click();
        inputConfirm.sendKeys(string);

        driver.findElement(By.xpath("//input[@type='radio' and @name='newsletter']")).click();
        driver.findElement(By.xpath("//input[@type='submit' and @value='Continue']")).click();
//    - Move to 'Desktops' and select 'Show all Desktops'
        driver.findElement(linkText("Desktops")).click();
        driver.findElement(linkText("Show All Desktops")).click();
//    - Choose 'MP3 Players' item
        driver.findElement(linkText("MP3 Players (4)")).click();
//    - Click on 'iPod Classic' link
        driver.findElement(linkText("iPod Classic")).click();
//    - Click on first image and move on another images before text '4 of 4' is present (check Pic1)
        driver.findElement(By.cssSelector(".thumbnail")).click();
        driver.findElement(By.xpath("//button[@title='Next (Right arrow key)']")).click();
        driver.findElement(By.xpath("//button[@title='Next (Right arrow key)']")).click();
        driver.findElement(By.xpath("//button[@title='Next (Right arrow key)']")).click();
//    - Click on 'Write a review' , fill information and submit
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(),'×')]")).click();
        js.executeScript("window.scrollBy(0, 500)");
        driver.findElement(linkText("Reviews (0)")).click();
        driver.findElement(cssSelector("#input-name")).sendKeys("saxeli");
        driver.findElement(cssSelector("#input-review")).sendKeys("review textreview textreview textreview textreview textreview textreview textreview textreview textreview textreview textreview textreview textreview text");
        driver.findElement(xpath("//input[@value='4']")).click();
        driver.findElement(cssSelector("#button-review")).click();
//    - Click on 'Add to Cart'
        js.executeScript("window.scrollBy(0, -200)");
        driver.findElement(cssSelector("#button-cart")).click();
//    - Check by item's count and price, that product was successfully added to cart (check Pic2)
        Thread.sleep(1000);
        String cart = driver.findElement(cssSelector("#cart-total")).getText().toString();
        Assert.assertEquals(cart, "1 item(s) - $122.00");
//    - Click on Pic2 element and click on 'Checkout'
        driver.findElement(cssSelector("#cart-total")).click();
        driver.findElement(xpath("//body[1]/header[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[2]/div[1]/p[1]/a[2]/strong[1]")).click();
    }
}