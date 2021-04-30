import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TC_VerifyFooterElement_013 extends BaseClass{
    public TC_VerifyFooterElement_013(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }
    public void verifyFooterElement() throws IOException {
        try {
            JavascriptExecutor js=(JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,4500)");
            By Footer= By.linkText("About Us");
            waitFor(Footer);
            click(Footer);
            driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
            takeScreenshot(driver);
            Assert.assertEquals(driver.getCurrentUrl(),"https://www.aboutamazon.in/?utm_source=gateway&utm_medium=footer");
            Reports.extentTest.log(Status.PASS,"Verification of footer element is successful");
        }
        catch (Exception e){
            Reports.extentTest.log(Status.FAIL,"Footer Element is not verified");
            takeScreenshot(driver);
        }

    }
}
