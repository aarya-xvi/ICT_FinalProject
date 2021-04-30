import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class TC_ValidateInvalidPincode_002 extends BaseClass{
    public TC_ValidateInvalidPincode_002(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    public void validateInvalidPin(String PIN){
        try {
            By Address=By.id("glow-ingress-line2");
            By Pincode=By.id("GLUXZipUpdateInput");
            By Apply=By.xpath("//*[@id=\"GLUXZipUpdate\"]/span/input");
            By Invalid=By.xpath("//*[@id=\"GLUXZipError\"]/div/div/div");
            click(Address);
            click(Pincode);
            sendKeys(Pincode,PIN);
            click(Apply);
            waitFor(Invalid);
            takeScreenshot(driver);
            Assert.assertTrue(getText(Invalid).contains("Please enter a valid pincode"));
            Reports.extentTest.log(Status.PASS,"Pincode Validation is successful");
        }
        catch (Exception e){
            Reports.extentTest.log(Status.FAIL,"Pincode Validation is successful");
        }

    }
}
