import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TC_VerifySearch_003 extends BaseClass{
    public TC_VerifySearch_003(WebDriver driver) {
        super(driver);
    }
    public void verifySearchTest(String product) throws IOException {
        try {
            By Search= By.id("twotabsearchtextbox");
            By search_buttn=By.id("nav-search-submit-button");
            driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
            sendKeys(Search,product);
            click(search_buttn);
            driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
            takeScreenshot(driver);
            Reports.extentTest.log(Status.PASS,"Search verification is successful");
        }catch (Exception e) {
            Reports.extentTest.log(Status.FAIL, "Search verification is successful");
            takeScreenshot(driver);
        }

    }
}
