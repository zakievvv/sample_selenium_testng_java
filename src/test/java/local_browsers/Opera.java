package local_browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


@Test(groups = {"mac", "windows"})
public class Opera {
    private WebDriver driver;

    @BeforeClass
    public void operaSetup(){
        WebDriverManager.operadriver().setup();
        driver = new OperaDriver();
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
