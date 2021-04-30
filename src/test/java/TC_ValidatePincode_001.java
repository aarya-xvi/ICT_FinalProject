import com.aventstack.extentreports.Status;
import com.beust.jcommander.Parameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC_ValidatePincode_001 extends BaseClass{

    public TC_ValidatePincode_001(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public void validatePincode(String pin){
        try {
            By Address=By.id("glow-ingress-line2");
            By Pincode=By.id("GLUXZipUpdateInput");
            By Apply=By.xpath("//*[@id=\"GLUXZipUpdate\"]/span/input");
            click(Address);
            waitFor(Pincode);
            click(Pincode);
            sendKeys(Pincode,pin);
            click(Apply);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            takeScreenshot(driver);
            Reports.extentTest.log(Status.PASS,"Pincode validation test is verified");
        }
        catch (Exception e){
            Reports.extentTest.log(Status.FAIL,"Pincode validation test is not verified");
        }
    }


}
