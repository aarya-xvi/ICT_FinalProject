import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Browser {
    static String baseDirectory=System.getProperty("user.dir");
    static WebDriver driver=null;



    public static void setUP(String browserName){
        if (browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver",baseDirectory+"//Drivers//chromedriver.exe");
            ChromeOptions options=new ChromeOptions();
            driver=new ChromeDriver(options);
            options.addArguments("--disable-notifications");
            driver.manage().window().maximize();
        }
        else if (browserName.equalsIgnoreCase("firefox")){

            System.setProperty("webdriver.gecko.driver",baseDirectory+"//Drivers//geckodriver.exe");
            FirefoxOptions options=new FirefoxOptions();
            driver=new FirefoxDriver(options);
            options.addArguments("--disable-notifications");
            driver.manage().window().maximize();
        }

    }

    public static WebDriver openBrowser(){

        driver.navigate().to("https://www.amazon.in/");
        return driver;
    }

    public static void closeBrowser(WebDriver driver){
        driver.close();
    }
}