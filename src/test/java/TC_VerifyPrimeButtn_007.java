import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class TC_VerifyPrimeButtn_007 extends BaseClass{

    public TC_VerifyPrimeButtn_007(WebDriver driver) {
        super(driver);
        this.driver =driver;
    }

    public void verifyPrimeButtn(){
        try {
            By PrimeButtn=By.id("nav-link-prime");
            By loginToJoinPrime=By.linkText("Login to join Prime");
            click(PrimeButtn);
            click(loginToJoinPrime);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            takeScreenshot(driver);
            Assert.assertEquals(driver.getTitle(),"Amazon Sign In");
            Reports.extentTest.log(Status.PASS,"Verification of Sign-in page is successful");
        }
        catch (Exception e)
        {
            By PrimeButtn=By.id("nav-link-prime");
            By loginToJoinPrime=By.linkText("Login to join Prime");
            click(PrimeButtn);
            click(loginToJoinPrime);
            Assert.assertEquals(driver.getTitle(),"Amazon Sign In");
            Reports.extentTest.log(Status.FAIL,"Verification of Sign-in page failed");
        }

    }
}


