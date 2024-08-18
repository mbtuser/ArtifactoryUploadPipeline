package samples.testng;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNGSamples {

    static RemoteWebDriver driver;
    static WebDriverWait waiter;

    @Test
    public void OpenLocalGIT() throws Exception {
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/login?from=%2F");
        Thread.sleep(1000);
        System.out.println("Page title is: " + driver.getTitle());
        Reporter.log("Page title is: " + driver.getTitle());
        Thread.sleep(5000);
    }
}
