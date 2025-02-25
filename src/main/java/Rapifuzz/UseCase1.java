package Rapifuzz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class UseCase1 {

    public static void main(String[] args) {
        System.setProperty("WebDriver.chrome.driver" ,"C:/Users/Pragati/IdeaProjects/SeleniumAuto/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://erail.in/");
        WebElement fromField = driver.findElement(By.id("txtStationFrom"));
        fromField.clear();
        fromField.sendKeys("DEL");
        List<WebElement> fromList =driver.findElements(By.xpath("(//div[@class='autocomplete'])[1]/div"));
        fromList.get(4).click();
        fromField.click();
        System.out.println(fromList.get(4).getText());





    }
}
