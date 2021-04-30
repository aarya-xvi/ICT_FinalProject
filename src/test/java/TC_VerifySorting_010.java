import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class TC_VerifySorting_010 extends BaseClass{
    public TC_VerifySorting_010(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }
    public void verifySorting(String item){
        try {
            By Search= By.id("twotabsearchtextbox");
            By SearchButtn=By.id("nav-search-submit-button");
            By sort=By.id("a-autoid-0-announce");
            By SortBy=By.id("s-result-sort-select_2");
            click(Search);
            sendKeys(Search,item);
            click(SearchButtn);
            click(sort);
            click(SortBy);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            takeScreenshot(driver);
            Reports.extentTest.log(Status.PASS,"Sorting action is successful");

        }catch (Exception e){
            Reports.extentTest.log(Status.FAIL,"Sorting action failed");
        }

    }
}
