import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class TC_VerifyInvalidAccountOpening_008 extends BaseClass{
    public TC_VerifyInvalidAccountOpening_008(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }
    public void verifyInvalidAccount(){try {
        By HelloButtn= By.id("nav-link-accountList");
        By createAccount=By.id("createAccountSubmit");
        By Continue=By.id("continue");
        By error1=By.xpath("//*[@id=\"auth-customerName-missing-alert\"]/div/div");
        By error2=By.xpath("//*[@id=\"auth-phoneNumber-missing-alert\"]/div/div");
        By error3=By.xpath("//*[@id=\"auth-password-missing-alert\"]/div/div");
        click(HelloButtn);
        click(createAccount);
        click(Continue);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        takeScreenshot(driver);
        Assert.assertEquals(getText(error1),"Enter your name");
        Assert.assertEquals(getText(error2),"Enter your mobile number");
        Assert.assertEquals(getText(error3),"Enter your password");
    }
       catch (Exception e){
        Reports.extentTest.log(Status.FAIL,"Verification of Invalid Account Opening is not successful");
       }
    }
}
