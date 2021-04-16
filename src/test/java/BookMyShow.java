import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class BookMyShow {

    private WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        driver=Browser.openBrowser();
    }
    @Test
    public void verifyCityName() throws IOException {
        Reports.createTest("Verify City Name-Positive");
        HomePage homePage=new HomePage(driver);
        //todo parametrise this get from dataprovider
        homePage.selectCity("Chennai");
        homePage.verifyCitySelection("Chennai");

    }

    @Test
    public void verifyCityName1() throws IOException {
        Reports.createTest("Verify City Name-Negative");
        HomePage homePage=new HomePage(driver);
        //todo parametrise this get from dataprovider
        homePage.selectCity("Chennai");
        homePage.verifyCitySelection("Kochi");



    }

    @AfterMethod
    public void closeBrowser(){
        Browser.closeBrowser(driver);
    }
}
