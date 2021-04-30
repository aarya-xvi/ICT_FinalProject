import com.aventstack.extentreports.utils.FileUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class BaseClass {
    public WebDriver driver;

    public BaseClass(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement locateElement(By locator){
        WebDriverWait wait=new WebDriverWait(driver,20);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    public void click(By locator){
        locateElement(locator).click();
    }

    public static String takeScreenshot(WebDriver driver) throws IOException {

        File screenshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        Random random=new Random();
        String fileName="Screenshot"+random.nextInt(10000);
        String destination= System.getProperty("user.dir")+"/report/"+fileName+".png";
        File finalDestination=new File(destination);
        try {
            FileHandler.copy(screenshot,finalDestination);
        }catch (IOException e){
            System.out.println("Capture Failed" +e.getMessage());
        }
        return destination;
    }

    public void sendKeys(By locator, String value){
        locateElement(locator).sendKeys(value);
    }


    public String getText(By locator){
        return locateElement(locator).getText();
    }
    public void waitFor(By locator){
        int i=0;
        while(i<10)
        {
        try {
            WebDriverWait Wait =new WebDriverWait(driver, 20);
            Wait.until(ExpectedConditions.elementToBeClickable(locator));
            break;
        }catch (Exception e){
            i++;
        }
        }
    }


}