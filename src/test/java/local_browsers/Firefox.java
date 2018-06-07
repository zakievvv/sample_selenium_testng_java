package local_browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups = {"mac", "windows"})
public class Firefox {
    private WebDriver driver;

    @BeforeClass
    public void firefoxSetup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @Test
    public void test() {
        driver.get("http://lazycoder.io/about.html");
        Assert.assertEquals(driver.getTitle(), "Lazy Coder Origins");
    }

    @AfterClass
    public void testTeardown() {
        driver.quit();
    }
}
