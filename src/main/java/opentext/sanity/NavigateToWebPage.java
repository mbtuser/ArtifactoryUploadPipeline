package opentext.sanity;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NavigateToWebPage {

    static RemoteWebDriver driver;
    static WebDriverWait waiter;

    @Test
    @Parameters({"site"})
    public void openWebPage(@Optional("https://www.google.com") String site) {
        driver.manage().window().maximize();
        driver.get(site);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        System.out.println("Page title is: " + driver.getTitle());
        Reporter.log("Page title is: " + driver.getTitle());
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test()
    @Parameters({"site", "pageName"})
    void verifyWebPageOpen(@Optional("https://www.google.com") String site, @Optional("Google") String pageName) {
        driver.manage().window().maximize();
        driver.get(site);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Assert.assertTrue(driver.getCurrentUrl().contains(site), "the URL is incorrect : Test Failed");
        Assert.assertTrue(driver.getTitle().contains(pageName), "the page name is incorrect : Test Failed");
        Reporter.log("navigate to " + site + " work properly");
    }
}
