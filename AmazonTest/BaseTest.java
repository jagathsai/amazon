// BaseTest.java
package AmazonTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C://Users//USER//Downloads//chromedriver_win32//chromedriver.exe//");
        driver = new ChromeDriver();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
