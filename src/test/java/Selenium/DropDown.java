package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;

import java.time.Duration;

public class DropDown {

    public static void main (String[] args) throws InterruptedException {

        System.setProperty("WebDriver.chorme.driver", "C:/Users/Pragati/IdeaProjects/SeleniumAuto/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement staticdrop = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dd = new Select(staticdrop);
        dd.selectByIndex(1);
        dd.selectByVisibleText("USD");
        dd.selectByValue("AED");
        System.out.println(dd.getFirstSelectedOption().getText());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(3000);
        int i =1;
        while(i<5){
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        driver.findElement(By.id("btnclosepaxoption")).click();

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        driver.findElement(By.xpath("(//a[@value='IXG'])[2]")).click();

//        driver.findElement(By.id("autosuggest")).sendKeys("ind");
//
//        Thread.sleep(3000);
//        List<WebElement> options =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
//
//        for(WebElement option : options){
//            if(option.getText().equalsIgnoreCase("India"));
//            Thread.sleep(3000);
//            option.click();
//            break;
//        }
//        WebElement wb1 = driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily"));
//        wb1.click();
//        Assert.assertTrue(wb1.isSelected());
//        wb1.click();
//        Assert.assertFalse(wb1.isSelected());
//
//        List<WebElement> ch1 = driver.findElements(By.xpath("//input[@type='checkbox']"));
//        System.out.println(ch1.size());
//        Thread.sleep(3000);
//        //driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']/following-sibling::button")).click();
//        //driver.findElement(By.cssSelector("a.ui-state-default.ui-state-active")).click();
//
//        System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
//        driver.findElement(By.cssSelector("input#ctl00_mainContent_rbtnl_Trip_1")).click();
//        System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
//        if(driver.findElement(By.id("Div1")).getDomAttribute("style").contains("1")){
//            System.out.println("it is enabled");
//                    Assert.assertTrue(true);
//        }
//        else {
//            Assert.assertTrue(false);
//        }
//        driver.findElement(By.cssSelector("input[name='ctl00$mainContent$btn_FindFlights']")).click();
//




    }
}
