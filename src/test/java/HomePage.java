import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class HomePage extends BasePage {

    private WebDriver driver;
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    private By imgChennaiCity=By.xpath("//img[@alt='CHEN']");
    private By drpdownCityName=By.xpath("//span[contains(@class,'ellipsis')]");

    //Todo parametrise city selection
    public void selectCity(String cityName){
        click(imgChennaiCity);
        Reports.extentTest.log(Status.INFO,"Selected City "+cityName);

    }
    public void verifyCitySelection(String cityName) throws IOException {
        String actualCity=getText(drpdownCityName);
        //todo generalise below statement

        try{
            Assert.assertEquals(actualCity,cityName,"City Name not matching, actual city is "+actualCity);
            Reports.extentTest.log(Status.PASS,"City verified as "+actualCity, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
        }
        //todo use listeners to capture failure
        catch (Exception e){
            Reports.extentTest.log(Status.FAIL,"City Name not matching, actual city is "+actualCity,MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
        }

    }
}
