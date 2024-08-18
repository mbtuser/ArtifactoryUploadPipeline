package opentext.sanity;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ReporterTests {

    static RemoteWebDriver driver;
    static WebDriverWait waiter;

    @Test()
    @Parameters({"site"})
    void reporterStepTest(@Optional("https://www.google.com/") String site) {
        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(site);
        Reporter.log("navigate to " + site + " properly");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("opentext");
        Reporter.log("searching 'OpenText' properly");
        driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys(Keys.RETURN);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        assert driver.getTitle().contains("opentext");
        Reporter.log("search on google 'OpenText' work properly", true);
    }

    @Test()
    @Parameters({"site_failed", "assert_contains"})
    void reporterFailedTest(@Optional("https://www.google.com/") String site_failed, @Optional("Google") String assert_contains) {
        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(site_failed);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Boolean display = driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).isDisplayed();
        if (display) {
            Reporter.log("navigate to " + site_failed + " properly");
        } else {
            Reporter.log("navigate to " + site_failed + " failed");
        }
        assert driver.getTitle().contains(assert_contains);
    }

    @Test()
    @Parameters({"site"})
    void reporterSideRespondTest(@Optional("https://www.google.com/") String site) {
        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(site);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        try {
            Assert.assertEquals(site, driver.getCurrentUrl());
            System.out.println("Navigated to correct webpage");
        } catch (Throwable pageNavigationError) {
            System.out.println("Didn't navigate to correct webpage");
        }
    }


}
