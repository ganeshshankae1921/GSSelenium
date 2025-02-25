package ganeshacademy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class loginTest {

    public static void main(String[] arge) throws InterruptedException {
        String ProductName = "IPHONE 13 PRO";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/client/");
        login(driver);
        addCartInList(driver, ProductName);
        verifyCart(driver, ProductName);
        paymentPage(driver);


    }

    public static void login(WebDriver driver){
        driver.findElement(By.id("userEmail")).sendKeys("ganesh@mailinator.com");
        driver.findElement(By.id("userPassword")).sendKeys("Ganesh@1920");
        driver.findElement(By.id("login")).click();
    }


    public static void addCartInList(WebDriver driver, String ProductName) throws InterruptedException {
        List<WebElement> itemList = driver.findElements(By.xpath("//div[contains(@class,'mb-3')]"));
      Thread.sleep(5000);
      WebElement prods =  itemList.stream().filter(item ->
              item.findElement(By.xpath("//div[@class='card-body']/h5/b")).getText()
              .equals(ProductName)).findFirst().orElse(null);
      System.out.println(prods);
      prods.findElement(By.xpath("//button[@class='btn w-10 rounded']")).click();
      WebDriverWait wt =new WebDriverWait(driver, Duration.ofSeconds(3));
      wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='toast-container']")));
      WebElement message = driver.findElement(By.xpath("//div[@id='toast-container']"));
      System.out.println(message.getText());
    }

    public static void verifyCart(WebDriver driver, String ProductName) throws InterruptedException {
        driver.findElement(By.xpath("(//button[contains(@class,'btn btn-custom')])[3]")).click();
        Thread.sleep(5000);
        List<WebElement> cartProducts = driver.findElements(By.xpath("//div[@class='cart']/ul"));
        Boolean match = cartProducts.stream().anyMatch(cartP -> cartP.findElement(By.xpath("//div[@class='cartSection']/h3")).getText().equalsIgnoreCase(ProductName));
        Assert.assertTrue(match);
        driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
    }

    public static void paymentPage(WebDriver driver){
        String country ="India";
        Actions at = new Actions(driver);
        at.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), country).build().perform();
        WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(6));
        wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.ta-item")));
        List<WebElement> countryLists = driver.findElements(By.cssSelector("button.ta-item"));
//        for(int i =0; i<countryLists.size(); i++){
//            if(country.equalsIgnoreCase(countryLists.get(i).getText()));
//            countryLists.get(i).click();
//            break;
//        }

        for(WebElement countryl : countryLists){
            if(countryl.getText().equalsIgnoreCase("india"));
            countryl.click();
            System.out.println("element se;ected");
        }
    //driver.findElement(By.cssSelector("a.action__submit")).click();

    }
}
