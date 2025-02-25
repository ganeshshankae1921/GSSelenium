package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class jsexecutor {

    public static void main(String[] args){
        System.setProperty("WebDriver.chrome.driver","C:/Users/Pragati/IdeaProjects/SeleniumAuto/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        scrollPage(driver);

    }

    public static void scrollPage(WebDriver driver){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");

        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
        int sum = 0;
        List<WebElement> amountList = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]"));
        for (int i = 0; i< amountList.size(); i++){
            sum =sum+ Integer.parseInt(amountList.get(i).getText());
        }
        System.out.println(sum);
    }
}
