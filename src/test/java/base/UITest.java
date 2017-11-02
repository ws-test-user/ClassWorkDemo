package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Base GitHub UI Test
 */
public class UITest {

    protected static WebDriver driver;

    @BeforeClass
    public void beforeUITests() {
        String driverPath = System.getProperty("user.dir") + File.separator + "lib" + File.separator + "chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void afterUITests() {
        try {
            driver.quit();
        } catch (Exception e) {
            System.out.println("Failed to quit browser.");
        }
    }
}
