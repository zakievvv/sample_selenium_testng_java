package local_browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups = {"windows"})
public class EdgeWithoutDriverManager {
    private WebDriver driver;

    @BeforeClass
    public void edgeSetup(){
        DesiredCapabilities capabilities = DesiredCapabilities.edge();
        EdgeOptions options = new EdgeOptions();
        capabilities.setCapability(EdgeOptions.CAPABILITY, options);
        driver = new EdgeDriver(capabilities);
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
