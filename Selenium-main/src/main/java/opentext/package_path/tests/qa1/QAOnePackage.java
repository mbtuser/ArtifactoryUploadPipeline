package opentext.package_path.tests.qa1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class QAOnePackage {
    static RemoteWebDriver driver;
    static WebDriverWait waiter;

    @Test()
    void googleSearchQAOneTest() {
        driver.manage().window().maximize();
        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("QA One");
        driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys(Keys.RETURN);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        assert driver.getTitle().contains("QA One");
        Reporter.log("search on google 'QA One' work properly");
    }

}
