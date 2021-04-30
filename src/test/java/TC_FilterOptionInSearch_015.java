import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TC_FilterOptionInSearch_015 extends BaseClass {
    public TC_FilterOptionInSearch_015(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void verifyFilterInSearch(String book) throws IOException {
        try {
            By searchFilter=By.id("searchDropdownBox");
            Select drop=new Select(driver.findElement(searchFilter));
            drop.selectByVisibleText("Books");
            By textbox=By.id("twotabsearchtextbox");
            click(textbox);
            sendKeys(textbox,book);
            By submitButton=By.id("nav-search-submit-button");
            click(submitButton);
            driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
            takeScreenshot(driver);
            Reports.extentTest.log(Status.PASS,"Verification of filter option in Search is successful");
        }catch (Exception e){
            takeScreenshot(driver);
            Reports.extentTest.log(Status.FAIL,"Filter option in Search is not verified");
        }

    }
}
