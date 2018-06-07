package local_browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


@Test(groups = {"mac", "windows"})
public class OperaWithoutDriverManager {
    private WebDriver driver;

    @BeforeClass
    public void operaSetup(){
        DesiredCapabilities capabilities = DesiredCapabilities.opera();
        OperaOptions options = new OperaOptions();
        capabilities.setCapability(OperaOptions.CAPABILITY, options);
        driver = new OperaDriver(capabilities);
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
