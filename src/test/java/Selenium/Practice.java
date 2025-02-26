package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Practice {

    public static WebDriver driver;


    @BeforeMethod
    public static void openBrowser(){
        System.setProperty("WebDriver.chrome.driver", "C:/Users/Pragati/IdeaProjects/SeleniumAuto/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    public static void assignment1(WebDriver driver){
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("input#username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("learning");
        driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='okayBtn']")));
        driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
        WebElement drop = driver.findElement(By.xpath("//select[@class='form-control']"));
        Select se = new Select(drop);
        se.selectByVisibleText("Consultant");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.cssSelector("input.btn.btn-info.btn-md")).click();

        //add to cart

        List<WebElement> items = driver.findElements(By.xpath("//button[@class='btn btn-info']"));
        for(int i=0; i<items.size();i++){
            items.get(i).click();
        }

        driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
        Set<String> window = driver.getWindowHandles();
        Iterator<String> it = window.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.xpath("//p[@class='hero_heading']")).getText().split("-")[1]);
        driver.switchTo().window(parentId);
    }

    @Test(priority = 1)
    public static void assignment2(){
        driver.get("https://the-internet.herokuapp.com/");
      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
        WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(5));
        wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='example']/h3")));
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        Set<String> window = driver.getWindowHandles();
        Iterator<String> it = window.iterator();
        String parentId = it.next();
        String childId = it.next();
        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
        driver.switchTo().window(parentId);
        System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
    }

    @Test(priority = 2)
    public static void assignment3(){
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
        WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(5));
        wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//frame[@name='frame-top']")));

        WebElement topframe = driver.findElement(By.xpath("//frame[@name='frame-top']"));
        driver.switchTo().frame(topframe);

        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.xpath("//div[text()='MIDDLE']")).getText());



    }

    @Test(priority = 3)
    public static void assignment4() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.tagName("a")).size());
        WebElement footer = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
        System.out.println(footer.findElements(By.tagName("a")).size());
        WebElement footer1 = driver.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]/ul"));
        for(int i=1; i< footer1.findElements(By.tagName("a")).size() ; i++){
            String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
            footer1.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
            Thread.sleep(5000);
            }
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        while(it.hasNext()){
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());

        }


    }

    @Test(priority = 4)
    public static void assignment5(){
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("input#checkBoxOption2")).click();
        String selectElement = driver.findElement(By.xpath("//input[@id='checkBoxOption2']/parent::label")).getText();
        System.out.println(selectElement);
        WebElement selectdrop = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
        Select st = new Select(selectdrop);
        st.selectByVisibleText(selectElement);

        driver.findElement(By.id("name")).sendKeys(selectElement);
        driver.findElement(By.id("alertbtn")).click();
        String alerttext = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        if(alerttext.contains(selectElement)){
            System.out.println("Alert message contains " + selectElement);
        }
        else{
            System.out.println("Alert message does not contains " + selectElement);
        }
    }

    @AfterMethod
    public static void closeBrowser(){
        driver.quit();
    }
}


