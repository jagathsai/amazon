package AmazonTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;

public class AmazonTest extends BaseTest {
    // ...

    @Test
    public void amazonTest() {
        WebDriver driver = getDriver();
        driver.get("https://www.amazon.in/");

        WebElement signInButton = driver.findElement(By.id("nav-link-accountList"));
        // Verify sign in button is visible
        assert signInButton.isDisplayed();

        WebElement hamburgerMenuIcon = driver.findElement(By.id("nav-hamburger-menu"));
        hamburgerMenuIcon.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mobilesComputersLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(), 'Mobiles, Computers')]")));
        mobilesComputersLink.click();

        // Wait for the main menu to disappear before clicking the link
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("hmenu-back-button")));

        WebElement allMobilePhonesLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("All Mobile Phones")));
        
        // Use Actions class to perform the click action
        Actions actions = new Actions(driver);
        actions.moveToElement(allMobilePhonesLink).click().perform();

        // Verify the header "Mobiles & Accessories" is visible
        WebElement headerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Mobiles & Accessories')]")));
        assert headerElement.isDisplayed();
    }
}
