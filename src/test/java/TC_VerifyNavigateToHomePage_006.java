import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class TC_VerifyNavigateToHomePage_006 extends BaseClass{
    public TC_VerifyNavigateToHomePage_006(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }
    public void verifyNavigation_to_HomePage(){
        try{
            By customerService= By.linkText("Customer Service");
            By amazonIcon=By.id("nav-logo-sprites");
            By Hello=By.linkText("Hello. What can we help you with?");
            click(customerService);
            click(amazonIcon);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            takeScreenshot(driver);
            Reports.extentTest.log(Status.PASS,"Navigation to Homepage is successful");
        }catch (Exception e){
            Reports.extentTest.log(Status.FAIL,"Navigation to Homepage is failed");
        }

    }
}
