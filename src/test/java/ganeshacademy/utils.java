package ganeshacademy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

public class utils {
     WebDriver driver;
    @Parameters("browser")
    public  void crossBrowser(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webDriver.chrome.driver", "url");
             driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webDriver.gecko.driver","url1");
                 driver = new FirefoxDriver();
            }

            else if(browser.equalsIgnoreCase("edge")){
                System.setProperty("webDriver.edge.driver", "url2");
                driver = new EdgeDriver();
            }

            else {

        }
    }
}
//<paramater name='browser" value ="chrome" />
// <parameter name ="browser" value= "chrome" />