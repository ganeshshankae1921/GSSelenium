package Selenium;

import net.bytebuddy.build.Plugin;
import org.apache.hc.core5.reactor.Command;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class AlertTest {
    WebDriver driver;
    String name = "ganesh";
    String[] items = {"Cucumber", "Mushroom", "Musk Melon"};

    @BeforeMethod
    public static void browserTest() {
        System.setProperty("webdriver.chrome.drive", "C:/Users/Pragati/IdeaProjects/SeleniumAuto/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
    }
    @Test()
    public void alertTest(){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement alerttextfield = driver.findElement(By.xpath("//input[@placeholder='Enter Your Name']"));

        alerttextfield.sendKeys(name);
        driver.findElement(By.cssSelector("input#alertbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        alerttextfield.sendKeys(name);
        driver.findElement(By.cssSelector("input#confirmbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
    }

    @Test
    public void addItems() {


        int j = 0;
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        List<WebElement> product = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < product.size(); i++) {
            String[] productnamesplit = product.get(i).getText().split("-");
            String productname = productnamesplit[0].trim();
            List itemName = Arrays.asList(items);
            if (itemName.contains(productname)) {
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (j == items.length) {
                    break;
                }
            }

        }
    }

    @Test
    public void verifyAlert(){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement alerttextfield = driver.findElement(By.xpath("//input[@placeholder='Enter Your Name']"));

        alerttextfield.sendKeys(name);
        WebDriverWait wt =  new WebDriverWait(driver , Duration.ofSeconds(2));
        driver.findElement(By.cssSelector("input#alertbtn")).click();
        if(wt.until(ExpectedConditions.alertIsPresent()) == null){
            System.out.println("No Alert Present");

        }
        else{
            driver.switchTo().alert().accept();
        }
    }



}
