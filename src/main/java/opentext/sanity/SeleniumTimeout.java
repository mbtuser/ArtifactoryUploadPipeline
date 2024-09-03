package opentext.sanity;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumTimeout {

    static RemoteWebDriver driver;
    static WebDriverWait waiter;

    @Test(timeOut = 300000)
    void executeFiveMinutes() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("QA tests 5 minute timeout");
        driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys(Keys.RETURN);
        Thread.sleep(300000);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        assert driver.getTitle().contains("QA tests 5 minute timeout");
        Reporter.log("search on google 'QA timeout tests' work properly");
    }

    @Test(timeOut = 480000)
    void executeEightMinutes() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.MINUTES);
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("QA tests 8 minute timeout");
        driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys(Keys.RETURN);
        Thread.sleep(480000);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        assert driver.getTitle().contains("QA tests 8 minute timeout");
        Reporter.log("search on google 'QA timeout tests' work properly");
    }

    @Test(timeOut = 600000)
    void executeTenMinutes() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("QA tests 10 minute timeout");
        driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys(Keys.RETURN);
        Thread.sleep(600000);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        assert driver.getTitle().contains("QA tests 10 minute timeout");
        Reporter.log("search on google 'QA timeout tests' work properly");
    }

    @Test(timeOut = 900000)
    void executeFifteenMinutes() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.MINUTES);
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("QA tests 15 minute timeout");
        driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys(Keys.RETURN);
        Thread.sleep(900000);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        assert driver.getTitle().contains("QA tests 15 minute timeout");
        Reporter.log("search on google 'QA timeout tests' work properly");
    }

}
