package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {

    public static void main(String[] args) throws InterruptedException {

        //System.setProperty("WebDriver.chrome.driver","C:/Users/Pragati/IdeaProjects/SeleniumAuto/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

//        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
//        driver.findElement(By.name("inputPassword")).sendKeys("test");
//        driver.findElement(By.className("submit")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("ganesh");
        driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("yyy");
        driver.findElement(By.cssSelector("button.signInBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("john");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("aaa@mailinator.com");
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("ganesh@mailinator.com");

        driver.findElement(By.xpath("//form/input[3]")).sendKeys("7845125895");

        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
        driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("rahul");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.id("chkboxTwo")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();



    }
}
