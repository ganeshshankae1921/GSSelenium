package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlertTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.drive", "C:/Users/Pragati/IdeaProjects/SeleniumAuto/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String name = "ganesh";
        String[] items = {"Cucumber", "Mushroom", "Musk Melon"};
//        alertTest(driver,name);
//        addItems(driver, items);
        verifyAlert(driver, name);

    }
    public static void alertTest(WebDriver driver, String name){


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
    public static void addItems(WebDriver driver, String[] items) {


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

    public static void verifyAlert(WebDriver driver, String name){
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
