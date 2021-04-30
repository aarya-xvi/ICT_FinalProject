import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class TC_Hamburger_011 extends BaseClass{
    public TC_Hamburger_011(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public void hamburgerTest(){
        try {
            By Hamburger= By.id("nav-hamburger-menu");
            By FireTv=By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[8]/a");
            By PrimeVideo=By.xpath("//*[@id=\"hmenu-content\"]/ul[3]/li[6]/a");
            click(Hamburger);
            waitFor(FireTv);
            click(FireTv);
            waitFor(PrimeVideo);
            click(PrimeVideo);
            driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
            takeScreenshot(driver);
            Reports.extentTest.log(Status.PASS,"Hamburger test is passed");
        }
        catch(Exception e){
            Reports.extentTest.log(Status.FAIL,"Hamburger Test failed");
        }
    }
}
