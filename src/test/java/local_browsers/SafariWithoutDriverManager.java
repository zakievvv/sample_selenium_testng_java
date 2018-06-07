package local_browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups = {"mac"})
public class SafariWithoutDriverManager {
    private WebDriver driver;

    @BeforeClass
    public void safariSetup(){
        DesiredCapabilities capabilities = DesiredCapabilities.safari();
        SafariOptions options = new SafariOptions();
        capabilities.setCapability(SafariOptions.CAPABILITY, options);
        driver = new SafariDriver(capabilities);
    }
    @Test
    public void test(){
        driver.get("http://lazycoder.io/about.html");
        Assert.assertEquals(driver.getTitle(), "Lazy Coder Origins");
    }

    @AfterClass
    public void testTeardown(){
        driver.quit();
    }
}
