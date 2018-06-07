package local_browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups = {"mac", "windows"})
public class PhantomJSWithoutDriverManager {
    private WebDriver driver;

    @BeforeClass
    public void phantomJSSetup(){
        //DesiredCapabilities capabilities = new DesiredCapabilities.phantomjs();
        driver = new PhantomJSDriver();
    }
    @Test
    public void test(){
        this.driver.get("http://lazycoder.io/about.html");
        Assert.assertEquals(driver.getTitle(), "Lazy Coder Origins");
    }

    @AfterClass
    public void testTeardown(){
        driver.quit();
    }
}
