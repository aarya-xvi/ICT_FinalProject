import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Amazon {
    private WebDriver driver;

    @BeforeMethod
    @Parameters("browserName")
    public void BrowserSelect(String browserName){
        Browser.setUP(browserName);
    }

    @BeforeMethod
    public void openBrowser() {
        driver = Browser.openBrowser();
    }

    @Test
    public void TC_VerifyPrimeButtn(){
        Reports.createTest("TC_VerifyPrimeButtn");
        TC_VerifyPrimeButtn_007 TC_7=new TC_VerifyPrimeButtn_007(driver);
        TC_7.verifyPrimeButtn();
    }

    @Test(dataProvider = "dp_1")
    public void TC_ValidatePincode(String pincode){
        Reports.createTest("TC_ValidatePin");
        TC_ValidatePincode_001 TC_1=new TC_ValidatePincode_001(driver);
        TC_1.validatePincode(pincode);
    }
    @DataProvider(name = "dp_1")
    public Object[][] PincodeData(){
        return new Object[][]{
                {"689121"},
                {"689504"}
        };
    }
    @Test(dataProvider = "dp_2")
    public void TC_ValidateInvalidPin(String pin){
        Reports.createTest("TC_ValidateInvalidPincode");
        TC_ValidateInvalidPincode_002 TC_2=new TC_ValidateInvalidPincode_002(driver);
        TC_2.validateInvalidPin(pin);
    }
    @DataProvider(name = "dp_2")
    public Object[][] InvalidPinData(){
        return new Object[][]{
                {"68912"},
                {"69504"}
        };
    }

    @Test
    public void TC_HamburgerTest(){
        Reports.createTest("TC_HamburgerTest");
        TC_Hamburger_011 TC_11=new TC_Hamburger_011(driver);
        TC_11.hamburgerTest();
    }

    @Test
    public void TC_VerifyFooter() throws IOException {
        Reports.createTest("TC_VerifyFooter");
        TC_VerifyFooterElement_013 TC_13=new TC_VerifyFooterElement_013(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        TC_13.verifyFooterElement();
    }

    @Test
    @Parameters("item")
    public void TC_VerifySort(String item){
        Reports.createTest("TC_VerifySort");
        TC_VerifySorting_010 TC_10=new TC_VerifySorting_010(driver);
        TC_10.verifySorting(item);
    }

    @Test
    public void TC_VerifyFilterInSearch() throws IOException {
        Reports.createTest("TC_VerifyFilterInSearch");
        TC_FilterOptionInSearch_015 TC_15=new TC_FilterOptionInSearch_015(driver);
        TC_15.verifyFilterInSearch("Da Vinci Code");
    }
//
    @Test
    @Parameters("product")
    public void TC_VerifySearch(String product) throws IOException {
        Reports.createTest("TC_VerifySearch");
        TC_VerifySearch_003 TC_3=new TC_VerifySearch_003(driver);
        TC_3.verifySearchTest(product);
    }

    @Test
    public void TC_VerifyNavigation(){
        Reports.createTest("TC_VerifyNavigation");
        TC_VerifyNavigateToHomePage_006 TC_6=new TC_VerifyNavigateToHomePage_006(driver);
        TC_6.verifyNavigation_to_HomePage();
    }

    @Test
    public void TC_VerifyInvalidAccountOpening(){
        Reports.createTest("TC_VerifyInvalidAccountOpening");
        TC_VerifyInvalidAccountOpening_008 TC_8=new TC_VerifyInvalidAccountOpening_008(driver);
        TC_8.verifyInvalidAccount();
    }


    @AfterMethod
    public void closeBrowser(){
        Browser.closeBrowser(driver);
    }



}

